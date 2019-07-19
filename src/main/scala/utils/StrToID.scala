package utils

object StrToID {
  def strToInt(str:String): Int ={
    try {
    str.toInt
    } catch {
      case _:Exception => 0
    }
  }
  def strToDouble(str:String): Double ={
    try {
      str.toDouble
    } catch {
      case _:Exception => 0.0
    }
  }
}
