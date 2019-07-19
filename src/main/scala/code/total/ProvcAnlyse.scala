package code.total

import org.apache.spark.SparkConf
import org.apache.spark.sql._
/**
  * @Author: SchearLoe
  * @Date: 2019/7/3 17:00
  * @Version 1.0
  */
object ProvcAnlyse {
  def main(args: Array[String]): Unit = {
//    if (args.length < 2)
//      {
//        System.exit(0)
//      }
    val Array(inputFile,outputFile) = args

    val conf = new SparkConf()
    //conf.setAppName(s"${this.getClass.getSimpleName}")
     conf.setAppName("Pro")
      .setMaster("local[*]")
    val spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()
    val df : DataFrame = spark.read.parquet(inputFile)
    df.createOrReplaceTempView("logs")

    val sql =
      """
        select
          count(*) ct,provincename,cityname
        from logs
         group by provincename,cityname
         order by provincename
      """
    spark.sql(sql).write.json(outputFile)
    spark.stop()
  }
}
