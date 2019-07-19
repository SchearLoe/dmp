package utils

import code.bean.LogsBean

/**
  * @Author: SchearLoe
  * @Date: 2019/7/3 15:33
  * @Version 1.0
  *      用于对不同维度的指标进行分析，提供指标分析工具方法
  */
object ReportUtils {

  /**
    * 对请求数进行统记
    * @param logsBean
    * @return List(原始请求数,有效请求数,广告请求数)
    */
  def calculateRequest(logsBean:LogsBean) : List[Double] = {
    if (logsBean.requestmode == 1){
      if (logsBean.processnode == 1){
        List(1,0,0)
      }else if (logsBean.processnode == 2){
        List(1,1,0)
      }else if (logsBean.processnode == 3){
        List(1,1,1)
      }else{
        List(0,0,0)
      }
    }else{
      List(0,0,0)
    }
  }

  /**
    * 计算竞价数
    * @param logsBean
    * @return List(参与竞价数,竞价成功数)
    */
  def calculateResponse(logsBean: LogsBean) : List[Double] = {
    if (logsBean.adplatformproviderid >= 100000 && logsBean.iseffective == 1 && logsBean.isbilling == 1) {
      if (logsBean.isbid == 1 && logsBean.adorderid != 0){
        List(1,0)
      }else if (logsBean.iswin == 1){
        List(0,1)
      }else{
        List(0,0)
      }
    }else{
      List(0,0)
    }
  }

  /**
    * 计算展示量和点击量
    * @param logsBean
    * @return List(展示量,点击量)
    */
  def calculateShowAndClick(logsBean: LogsBean) : List[Double] = {
    if(logsBean.iseffective == 1){
      if (logsBean.requestmode == 2){
        List(1,0)
      }else if (logsBean.requestmode == 3){
        List(0,1)
      }else{
        List(0,0)
      }
    }else{
      List(0,0)
    }
  }

  /**
    * 计算广告消费和广告成本
    * @param logsBean
    * @return List(dsp广告消费,dsp广告成本)
    */
  def calculateAdCost(logsBean: LogsBean) : List[Double] = {
    if (logsBean.adplatformproviderid >= 100000
      && logsBean.adcreativeid >= 200000
      && logsBean.iseffective == 1
      && logsBean.isbilling == 1
      && logsBean.iswin == 1){
      List(logsBean.winprice/1000,logsBean.adpayment/1000)
    }else{
      List(0.0,0.0)
    }
  }
}
