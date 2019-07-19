package code.total

import code.bean.LogsBean
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/**
  * @Author: SchearLoe
  * @Date: 2019/7/3 15:58
  * @Version 1.0
  *         日志文件初步清洗序列化到本地
  */
object Txt2Parquet {
  /**
    * @param args inputPath outputPath compressionCode
    */
  def main(args: Array[String]): Unit = {
    //参数判断
    if (args.length < 3){
      System.exit(0)
    }

    //接收参数
    val Array(dataPath,outputPath,compressionCode) = args
    //指定序列化格式
    val conf = new SparkConf().set("spark.serializer","org.apache.spark.serializer.KryoSerializer")
      .setMaster("local[2]")
    //注册LogsBean类的序列化格式为Kryo
    conf.registerKryoClasses(Array(classOf[LogsBean]))
    //设置压缩的格式
    conf.set("spark.io.compression.codec",compressionCode)
    //创建SparkSession
    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()


    //读文件，做相应的操作
    val logRDD : RDD[LogsBean] = spark.sparkContext.textFile(dataPath).map(line => {
      LogsBean.line2Logs(line)
    }).filter(!_.sessionid.equals(""))
    import spark.implicits._
    val df = logRDD.toDF()

    df.write.parquet(outputPath)

    spark.stop()
  }
}
