package practice.matchLearn

object test3 extends App {
  def matchType(x:Any):String = x match {
    case x @ List(1,_*) => s"$x"
    case x @ Some(_) => s"$x"
    case p @ Person(first,"Doe") => s"$p"
  }
//  捕获异常
  def myToInt(s:String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e:Exception => None
    }
  }
//  抛出异常
  @throws(classOf[NumberFormatException])
  def myToInt2(s:String): Option[Int] = {
    try {
      Some(s.toInt)
    }catch {
      case e: NumberFormatException => throw e
    }
  }
  myToInt("as") match {
    case Some(i) => println(i)
    case None => println("That wasn't an Int.")
  }
  println(matchType(List(1,2,3)))
  println(matchType((Some("foo"))))
  println(matchType((Person("John","Doe"))))
}
