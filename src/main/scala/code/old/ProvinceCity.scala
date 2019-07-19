package code.old

import java.util.Properties

import org.apache.spark.sql.DataFrame

/**
  * @Author: SchearLoe
  * @Date: 2019/7/3 15:35
  * @Version 1.0
  */
object ProvinceCity {
  def proCity(df:DataFrame): Unit ={
    val frame = df.groupBy("provincename","cityname")
      .count()
      .selectExpr("count as ct","provincename","cityname")
    //frame.coalesce(1).write.json("C:\\Users\\min\\Desktop\\abc\\proci")
    val pro = new Properties()
    pro.setProperty("driver","com.mysql.jdbc.Driver")
    pro.setProperty("user","root")
    pro.setProperty("password","root")
    frame.coalesce(1).write.jdbc("jdbc:mysql://10.0.153.250:3306/dmp","proci",pro)


  }
}
