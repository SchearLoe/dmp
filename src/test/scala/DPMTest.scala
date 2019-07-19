/**
  * @Author: SchearLoe
  * @Date: 2019/7/2 17:32
  * @Version 1.0
  */
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types._
import org.apache.spark.{SparkConf, SparkContext}
import utils.StrToID

/**
  * @Author: SchearLoe
  * @Date: 2019/7/2 15:21
  * @Version 1.0
  */
object DMPTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SparkDMPDemo").setMaster("local[2]").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
    val sc = new SparkContext(conf)
    val ss = SparkSession.builder().config(conf).getOrCreate()
    val lines = sc.textFile("D:\\OneDriveStudent\\OneDrive - vip.henu.edu.cn\\BigData课程\\Spark阶段\\gp1819\\dmp项目\\DMP项目\\2016-10-01_06_p1_invalid.1475274123982.log.FINISH")
    val schema = StructType(List(
      StructField("sessionid",StringType,true),
      StructField("advertisersid",IntegerType,true),
      StructField("adorderid",IntegerType,true),
      StructField("adcreativeid",IntegerType,true),
      StructField("adplatformproviderid",IntegerType,true),
      StructField("sdkversion",StringType,true),
      StructField("adplatformkey",StringType,true),
      StructField("putinmodeltype",IntegerType,true),
      StructField("requestmode",IntegerType,true),
      StructField("adprice",DoubleType,true),
      StructField("adppprice",DoubleType,true),
      StructField("requestdate",StringType,true),
      StructField("ip",StringType,true),
      StructField("appid",StringType,true),
      StructField("appname",StringType,true),
      StructField("uuid",StringType,true),
      StructField("device",StringType,true),
      StructField("client",IntegerType,true),
      StructField("osversion",StringType,true),
      StructField("density",StringType,true),
      StructField("pw",IntegerType,true),
      StructField("ph",IntegerType,true),
      StructField("long",StringType,true),
      StructField("lat",StringType,true),
      StructField("provincename",StringType,true),
      StructField("cityname",StringType,true),
      StructField("ispid",IntegerType,true),
      StructField("ispname",StringType,true),
      StructField("networkmannerid",IntegerType,true),
      StructField("networkmannername",StringType,true),
      StructField("iseffective",IntegerType,true),
      StructField("isbilling",IntegerType,true),
      StructField("adspacetype",IntegerType,true),
      StructField("adspacetypename",StringType,true),
      StructField("devicetype",IntegerType,true),
      StructField("processnode",IntegerType,true),
      StructField("apptype",IntegerType,true),
      StructField("district",StringType,true),
      StructField("paymode",IntegerType,true),
      StructField("isbid",IntegerType,true),
      StructField("bidprice",DoubleType,true),
      StructField("winprice",DoubleType,true),
      StructField("iswin",IntegerType,true),
      StructField("cur",StringType,true),
      StructField("rate",DoubleType,true),
      StructField("cnywinprice",DoubleType,true),
      StructField("imei",StringType,true),
      StructField("mac",StringType,true),
      StructField("idfa",StringType,true),
      StructField("openudid",StringType,true),
      StructField("androidid",StringType,true),
      StructField("rtbprovince",StringType,true),
      StructField("rtbcity",StringType,true),
      StructField("rtbdistrict",StringType,true),
      StructField("rtbstreet",StringType,true),
      StructField("storeurl",StringType,true),
      StructField("realip",StringType,true),
      StructField("isqualityapp",IntegerType,true),
      StructField("bidfloor",DoubleType,true),
      StructField("aw",IntegerType,true),
      StructField("ah",IntegerType,true),
      StructField("imeimd5",StringType,true),
      StructField("macmd5",StringType,true),
      StructField("idfamd5",StringType,true),
      StructField("openudidmd5",StringType,true),
      StructField("androididmd5",StringType,true),
      StructField("imeisha1",StringType,true),
      StructField("macsha1",StringType,true),
      StructField("idfasha1",StringType,true),
      StructField("openudidsha1",StringType,true),
      StructField("androididsha1",StringType,true),
      StructField("uuidunknow",StringType,true),
      StructField("userid",StringType,true),
      StructField("iptype",IntegerType,true),
      StructField("initbidprice",DoubleType,true),
      StructField("adpayment",DoubleType,true),
      StructField("agentrate",DoubleType,true),
      StructField("lomarkrate",DoubleType,true),
      StructField("adxrate",DoubleType,true),
      StructField("title",StringType,true),
      StructField("keywords",StringType,true),
      StructField("tagid",StringType,true),
      StructField("callbackdate",StringType,true),
      StructField("channelid",StringType,true),
      StructField("mediatype",IntegerType,true)
    ))
    val rowRDD:RDD[Row] = lines.map(line => {
      val arr = line.replace(",,",", ,")
        .replace(",\n",", \n")
        .split(",")
      Row(arr(0),
        StrToID.strToInt(arr(1)),
        StrToID.strToInt(arr(2)),
        StrToID.strToInt(arr(3)),
        StrToID.strToInt(arr(4)),
        arr(5),
        arr(6),
        StrToID.strToInt(arr(7)),
        StrToID.strToInt(arr(8)),
        StrToID.strToDouble(arr(9)),
        StrToID.strToDouble(arr(10)),
        arr(11),
        arr(12),
        arr(13),
        arr(14),
        arr(15),
        arr(16),
        StrToID.strToInt(arr(17)),
        arr(18),
        arr(19),
        StrToID.strToInt(arr(20)),
        StrToID.strToInt(arr(21)),
        arr(22),
        arr(23),
        arr(24),
        arr(25),
        StrToID.strToInt(arr(26)),
        arr(27),
        StrToID.strToInt(arr(28)),
        arr(29),
        StrToID.strToInt(arr(30)),
        StrToID.strToInt(arr(31)),
        StrToID.strToInt(arr(32)),
        arr(33),
        StrToID.strToInt(arr(34)),
        StrToID.strToInt(arr(35)),
        StrToID.strToInt(arr(36)),
        arr(37),
        StrToID.strToInt(arr(38)),
        StrToID.strToInt(arr(39)),
        StrToID.strToDouble(arr(40)),
        StrToID.strToDouble(arr(41)),
        StrToID.strToInt(arr(42)),
        arr(43),
        StrToID.strToDouble(arr(44)),
        StrToID.strToDouble(arr(45)),
        arr(46),
        arr(47),
        arr(48),
        arr(49),
        arr(50),
        arr(51),
        arr(52),
        arr(53),
        arr(54),
        arr(55),
        arr(56),
        StrToID.strToInt(arr(57)),
        StrToID.strToDouble(arr(58)),
        StrToID.strToInt(arr(59)),
        StrToID.strToInt(arr(60)),
        arr(61),
        arr(62),
        arr(63),
        arr(64),
        arr(65),
        arr(66),
        arr(67),
        arr(68),
        arr(69),
        arr(70),
        arr(71),
        arr(72),
        StrToID.strToInt(arr(73)),
        StrToID.strToDouble(arr(74)),
        StrToID.strToDouble(arr(75)),
        StrToID.strToDouble(arr(76)),
        StrToID.strToDouble(arr(77)),
        StrToID.strToDouble(arr(78)),
        arr(79),
        arr(80),
        arr(81),
        arr(82),
        arr(83),
        StrToID.strToInt(arr(84))
      )
    })

    val df = ss.createDataFrame(rowRDD,schema)
    df.coalesce(1).write.parquet("D:\\DMPFile\\a")
    ss.stop()
    sc.stop()
  }
}
