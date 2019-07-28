package practice.matchLearn
import implicitClass.utils._
import implicitClass.stringToInt._
object test extends App {
  def equalWithTolerance(a:Double,b:Double,precision:Double) ={
    if ((a-b).abs < precision) true else false
  }

  def toInt(s:String):Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: NumberFormatException => None
    }
  }
  println("Hello, world!".repeat)
  println("abc".increment)
  println("bcd".decrement)
  println("3".plusOne)
  println("zero".asBoolean)
  println("10".stringToInt(8))
  println(toInt("1"))
  println(toInt("a").getOrElse(0))
  println(equalWithTolerance(0.3,0.1+0.2,0.000001))
}
