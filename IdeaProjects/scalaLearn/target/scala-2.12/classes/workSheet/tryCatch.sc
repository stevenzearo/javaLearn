val s = "Foo"
//异常的捕捉
try {
  val i = s.toInt
} catch {
//  case e:Exception => e.printStackTrace
//  case t:Throwable => t.printStackTrace
//  上一行用于捕获未知异常,Throwable为一般异常的超集
  case _: Throwable => println("exception ignored")
}
val a = "a"