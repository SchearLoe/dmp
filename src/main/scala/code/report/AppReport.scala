package code.report

import code.bean.LogsBean
import org.apache.spark.{SparkConf, SparkContext}
import utils.ReportUtils

/**
  * @Author: SchearLoe
  * @Date: 2019/7/4 23:32
  * @Version 1.0
  *         媒体分析报告（App）
  */
object AppReport {
  /**
    *
    * @param args logDataPath appMappingPath outputPath
    */
  def main(args: Array[String]): Unit = {
    if (args.length < 3){
      System.exit(0)
    }

    val Array(logDataPath,appMappingPath,outputPath) = args

    val conf = new SparkConf()
      .setAppName(s"${this.getClass.getSimpleName}")
      .setMaster("local")
      .set("spark.serializer","org.apache.spark.serializer.KryoSerializer")
      .registerKryoClasses(Array(classOf[LogsBean]))
    val sc = new SparkContext(conf)

    /**
      * Read file,make data to DataFrame,then broadcast DF
      * cause AppName may changed, and AppID is only, use Map()
      */
    val appMap : Map[String,String] = sc.textFile(appMappingPath)
      .flatMap(line => {
        import scala.collection.mutable.Map
        val map = Map[String,String]()
        val fields:Array[String] = line.split("\t")
        map += (fields(4) -> fields(1))
        map
      }).collect().toMap
    val broadcastAppName = sc.broadcast(appMap)

    /**
      * Generate report
      */
    sc.textFile(logDataPath)
      //Use utils.ReportUtils generate data
      .map(line => {
      val logsBean = LogsBean.line2Logs(line)
      val adRequest = ReportUtils.calculateRequest(logsBean)
      val adResponse = ReportUtils.calculateResponse(logsBean)
      val adShowAndClick = ReportUtils.calculateShowAndClick(logsBean)
      val adCost = ReportUtils.calculateAdCost(logsBean)
      val appName = broadcastAppName.value.getOrElse(logsBean.appid,logsBean.appname)
      // List(1,1) ++ List(0,0) => List(1,1,0,0)
      (appName,adRequest ++ adResponse ++ adShowAndClick ++ adCost)
      })
      // Filtered data whitch have none AppName
      .filter(tuple => {
        tuple._1.nonEmpty && !"".equals(tuple._1)
      })
      // Reduce by AppName and consolidated data
      .reduceByKey{
       case (list1,list2) => {
        //List(0,0).zip(List(1,1)) => List((0,1),(0,1))
          list1.zip(list2).map{
            case (x,y) => x + y
          }
        }
      }
      // Loop output data
      .foreach(tuple => {
        val appName = tuple._1
        val report = tuple._2.mkString(",")
        println(appName + " " + report)
      })

    sc.stop()
  }

}
