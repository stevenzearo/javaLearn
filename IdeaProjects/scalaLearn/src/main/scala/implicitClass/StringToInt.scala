package implicitClass
package object stringToInt {
  implicit class StringToInt(s:String) {
    @throws(classOf[NumberFormatException])
//    上一行为设置抛出异常
    def stringToInt(radix:Int) = Integer.parseInt(s,radix)//radix参数为进制单位
  }
}