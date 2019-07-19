package code.bean

import utils.StrToID

/**
  * @Author: SchearLoe
  * @Date: 2019/7/3 15:36
  * @Version 1.0
  */
case class LogsBean(
         val sessionid : String, 	//会话标识
         val advertisersid : Int, 	//广告主 id
         val adorderid : Int, 	//广告 id
         val adcreativeid : Int, 	//广告创意 id ( >= 200000 : dsp)
         val adplatformproviderid : Int, 	//广告平台商 id (>= 100000: rtb)
         val sdkversion : String, 	//sdk 版本号
         val adplatformkey : String, 	//平台商 key
         val putinmodeltype : Int, 	//针对广告主的投放模式,1：展示量投放 2：点击量投放
         val requestmode : Int, 	//数据请求方式（1:请求、2:展示、3:点击）
         val adprice : Double, 	//广告价格
         val adppprice : Double, 	//平台商价格
         val requestdate : String, 	//请求时间,格式为：yyyy-m-dd hh:mm:ss
         val ip : String, 	//设备用户的真实 ip 地址
         val appid : String, 	//应用 id
         val appname : String, 	//应用名称
         val uuid : String, 	//设备唯一标识
         val device : String, 	//设备型号，如 htc、iphone
         val client : Int, 	//设备类型 （1：android 2：ios 3：wp）
         val osversion : String, 	//设备操作系统版本
         val density : String, 	//设备屏幕的密度
         val pw : Int, 	//设备屏幕宽度
         val ph : Int, 	//设备屏幕高度
         val longe : String, 	//设备所在经度
         val lat : String, 	//设备所在纬度
         val provincename : String, 	//设备所在省份名称
         val cityname : String, 	//设备所在城市名称
         val ispid : Int, 	//运营商 id
         val ispname : String, 	//运营商名称
         val networkmannerid : Int, 	//联网方式 id
         val networkmannername : String, 	//联网方式名称
         val iseffective : Int, 	//有效标识（有效指可以正常计费的）(0：无效 1：有效
         val isbilling : Int, 	//是否收费（0：未收费 1：已收费）
         val adspacetype : Int, 	//广告位类型（1：banner 2：插屏 3：全屏）
         val adspacetypename : String, 	//广告位类型名称（banner、插屏、全屏）
         val devicetype : Int, 	//设备类型（1：手机 2：平板）
         val processnode : Int, 	//流程节点（1：请求量 kpi 2：有效请求 3：广告请求）
         val apptype : Int, 	//应用类型 id
         val district : String, 	//设备所在县名称
         val paymode : Int, 	//针对平台商的支付模式，1：展示量投放(CPM) 2：点击
         val isbid : Int, 	//是否 rtb
         val bidprice : Double, 	//rtb 竞价价格
         val winprice : Double, 	//rtb 竞价成功价格
         val iswin : Int, 	//是否竞价成功
         val cur : String, 	//values:usd|rmb 等
         val rate : Double, 	//汇率
         val cnywinprice : Double, 	//rtb 竞价成功转换成人民币的价格
         val imei : String, 	//Imei（移动设备识别码）
         val mac : String, 	//Mac（苹果设备）
         val idfa : String, 	//Idfa（广告标识符）
         val openudid : String, 	//Openudid（UDID的第三方解决方案）
         val androidid : String, 	//Androidid（安卓设备的唯一id）
         val rtbprovince : String, 	//rtb 省
         val rtbcity : String, 	//rtb 市
         val rtbdistrict : String, 	//rtb 区
         val rtbstreet : String, 	//rtb 街 道
         val storeurl : String, 	//app 的市场下载地址
         val realip : String, 	//真实 ip
         val isqualityapp : Int, 	//优选标识
         val bidfloor : Double, 	//底价
         val aw : Int, 	//广告位的宽
         val ah : Int, 	//广告位的高
         val imeimd5 : String, 	//imei_md5
         val macmd5 : String, 	//mac_md5
         val idfamd5 : String, 	//idfa_md5
         val openudidmd5 : String, 	//openudid_md5
         val androididmd5 : String, 	//androidid_md5
         val imeisha1 : String, 	//imei_sha1
         val macsha1 : String, 	//mac_sha1
         val idfasha1 : String, 	//idfa_sha1
         val openudidsha1 : String, 	//openudid_sha1
         val androididsha1 : String, 	//androidid_sha1
         val uuidunknow : String, 	//uuid_unknow tanx 密文
         val userid : String, 	//平台用户 id
         val iptype : Int, 	//表示 ip 类型
         val initbidprice : Double, 	//初始出价
         val adpayment : Double, 	//转换后的广告消费
         val agentrate : Double, 	//代理商利润率
         val lomarkrate : Double, 	//代理利润率
         val adxrate : Double, 	//媒介利润率
         val title : String, 	//标题
         val keywords : String, 	//关键字
         val tagid : String, 	//广告位标识(当视频流量时值为视频 ID 号)
         val callbackdate : String, 	//回调时间 格式为:YYYY/mm/dd hh:mm:ss
         val channelid : String, 	//频道 ID
         val mediatype : Int	//媒体类型：1 长尾媒体 2 视频媒体 3 独立媒体 默认:1
      )extends Serializable
{

}

object LogsBean{
  /**
    * 将line数据转换为Logs类型数据
    * @param line
    * @return
    */
  def line2Logs(line : String):LogsBean = {
  if (!line.isEmpty){
    val fields = line.split(",")
    if (fields.length >= 85){
      new LogsBean(
        fields(0),
        StrToID.strToInt(fields(1)),
        StrToID.strToInt(fields(2)),
        StrToID.strToInt(fields(3)),
        StrToID.strToInt(fields(4)),
        fields(5),
        fields(6),
        StrToID.strToInt(fields(7)),
        StrToID.strToInt(fields(8)),
        StrToID.strToDouble(fields(9)),
        StrToID.strToDouble(fields(10)),
        fields(11),
        fields(12),
        fields(13),
        fields(14),
        fields(15),
        fields(16),
        StrToID.strToInt(fields(17)),
        fields(18),
        fields(19),
        StrToID.strToInt(fields(20)),
        StrToID.strToInt(fields(21)),
        fields(22),
        fields(23),
        fields(24),
        fields(25),
        StrToID.strToInt(fields(26)),
        fields(27),
        StrToID.strToInt(fields(28)),
        fields(29),
        StrToID.strToInt(fields(30)),
        StrToID.strToInt(fields(31)),
        StrToID.strToInt(fields(32)),
        fields(33),
        StrToID.strToInt(fields(34)),
        StrToID.strToInt(fields(35)),
        StrToID.strToInt(fields(36)),
        fields(37),
        StrToID.strToInt(fields(38)),
        StrToID.strToInt(fields(39)),
        StrToID.strToDouble(fields(40)),
        StrToID.strToDouble(fields(41)),
        StrToID.strToInt(fields(42)),
        fields(43),
        StrToID.strToDouble(fields(44)),
        StrToID.strToDouble(fields(45)),
        fields(46),
        fields(47),
        fields(48),
        fields(49),
        fields(50),
        fields(51),
        fields(52),
        fields(53),
        fields(54),
        fields(55),
        fields(56),
        StrToID.strToInt(fields(57)),
        StrToID.strToDouble(fields(58)),
        StrToID.strToInt(fields(59)),
        StrToID.strToInt(fields(60)),
        fields(61),
        fields(62),
        fields(63),
        fields(64),
        fields(65),
        fields(66),
        fields(67),
        fields(68),
        fields(69),
        fields(70),
        fields(71),
        fields(72),
        StrToID.strToInt(fields(73)),
        StrToID.strToDouble(fields(74)),
        StrToID.strToDouble(fields(75)),
        StrToID.strToDouble(fields(76)),
        StrToID.strToDouble(fields(77)),
        StrToID.strToDouble(fields(78)),
        fields(79),
        fields(80),
        fields(81),
        fields(82),
        fields(83),
        StrToID.strToInt(fields(84))
      )
    }else {
      //生成空对象
      makeLogs()
    }
  }else {
    makeLogs()
  }
  }
  def makeLogs(): LogsBean ={
    new LogsBean("",0,0,0,0,"",
      "",0,0,0.0,0.0,"",
      "","","","","",0,"","",0,
      0,"","","","",0,"",0,
      "",0,0,0,"",0,
      0,0,"",0,0,0.0,0.0,0,
      "",0.0,0.0,"","","","","","",
      "","","","","",0,0.0,0,0,
      "","","","","","","",
      "","","","","",0,0.0,
      0.0,0.0,0.0,0.0,"","","","",
      "",0)
  }
}
