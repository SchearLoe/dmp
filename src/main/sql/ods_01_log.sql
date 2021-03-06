create database if not exists dmp;
use dmp;
create table if not exists dmp.ods_01_log(
    sessionid String comment '会话标识',
    advertisersid Int comment '广告主 id',
    adorderid Int comment '广告 id',
    adcreativeid Int comment '广告创意 id ( >= 200000 : dsp)',
    adplatformproviderid Int comment '广告平台商 id (>= 100000: rtb)',
    sdkversion String comment 'sdk 版本号',
    adplatformkey String comment '平台商 key',
    putinmodeltype Int comment '针对广告主的投放模式,1：展示量投放 2：点击量投放',
    requestmode Int comment '数据请求方式（1:请求、2:展示、3:点击）',
    adprice Double comment '广告价格',
    adppprice Double comment '平台商价格',
    requestdate String comment '请求时间,格式为：yyyy-m-dd hh:mm:ss',
    ip String comment '设备用户的真实 ip 地址',
    appid String comment '应用 id',
    appname String comment '应用名称 ',
    uuid String comment '设备唯一标识',
    device String comment '设备型号，如 htc、iphone',
    client Int comment '设备类型 （1：android 2：ios 3：wp）',
    osversion String comment '设备操作系统版本',
    density String comment '设备屏幕的密度',
    pw Int comment '设备屏幕宽度',
    ph Int comment '设备屏幕高度',
    long String comment '设备所在经度',
    lat String comment '设备所在纬度',
    provincename String comment '设备所在省份名称',
    cityname String comment '设备所在城市名称',
    ispid Int comment '运营商 id',
    ispname String comment '运营商名称',
    networkmannerid Int comment '联网方式 id',
    networkmannername String comment '联网方式名称',
    iseffective Int comment '有效标识（有效指可以正常计费的）(0：无效 1：有效',
    isbilling Int comment '是否收费（0：未收费 1：已收费）',
    adspacetype Int comment '广告位类型（1：banner 2：插屏 3：全屏）',
    adspacetypename String comment '广告位类型名称（banner、插屏、全屏）',
    devicetype Int comment '设备类型（1：手机 2：平板）',
    processnode Int comment '流程节点（1：请求量 kpi 2：有效请求 3：广告请求）',
    apptype Int comment '应用类型 id',
    district String comment '设备所在县名称',
    paymode Int comment '针对平台商的支付模式，1：展示量投放(CPM) 2：点击',
    isbid Int comment '是否 rtb',
    bidprice Double comment 'rtb 竞价价格',
    winprice Double comment 'rtb 竞价成功价格',
    iswin Int comment '是否竞价成功',
    cur String comment 'values:usd|rmb 等',
    rate Double comment '汇率',
    cnywinprice Double comment 'rtb 竞价成功转换成人民币的价格',
    imei String comment 'Imei（移动设备识别码）',
    mac String comment 'Mac（苹果设备）',
    idfa String comment 'Idfa（广告标识符）',
    openudid String comment 'Openudid（UDID的第三方解决方案）',
    androidid String comment 'Androidid（安卓设备的唯一id）',
    rtbprovince String comment 'rtb 省',
    rtbcity String comment 'rtb 市',
    rtbdistrict String comment 'rtb 区',
    rtbstreet String comment 'rtb 街 道',
    storeurl String comment 'app 的市场下载地址',
    realip String comment '真实 ip ',
    isqualityapp Int comment '优选标识',
    bidfloor Double comment '底价',
    aw Int comment '广告位的宽',
    ah Int comment '广告位的高',
    imeimd5 String comment 'imei_md5',
    macmd5 String comment 'mac_md5',
    idfamd5 String comment 'idfa_md5',
    openudidmd5 String comment 'openudid_md5',
    androididmd5 String comment 'androidid_md5',
    imeisha1 String comment 'imei_sha1',
    macsha1 String comment 'mac_sha1',
    idfasha1 String comment 'idfa_sha1',
    openudidsha1 String comment 'openudid_sha1',
    androididsha1 String comment 'androidid_sha1',
    uuidunknow String comment 'uuid_unknow tanx 密文',
    decuuidunknow String comment '解密的 tanx 明文',
    userid String comment '平台用户 id',
    reqdate String comment '日期',
    reqhour String comment '小时',
    iptype Int comment '表示 ip 类型',
    initbidprice Double comment '初始出价',
    adpayment Double comment '转换后的广告消费',
    agentrate Double comment '代理商利润率',
    lomarkrate Double comment '代理利润率',
    adxrate Double comment '媒介利润率',
    title String comment '标题',
    keywords String comment '关键字',
    tagid String comment '广告位标识(当视频流量时值为视频 ID 号)',
    callbackdate String comment '回调时间 格式为:YYYY/mm/dd hh:mm:ss',
    channelid String comment '频道 ID',
    mediatype Int comment '媒体类型：1 长尾媒体 2 视频媒体 3 独立媒体 默认:1',
    ct bigint comment '创建时间'
)partitioned by (reqdate string)
    stored as parquet
    location '/lyx/dmp/'
;
