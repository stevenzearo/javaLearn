package practice.matchLearn

object test2 extends App {
  case class Dog(val name: String)
  case class Person(val firstName:String, val lastName:String)
  val mat = new MatchFromGave{}
  println(mat.echoWhatYouGaveMe(0))
  println(mat.echoWhatYouGaveMe(true))
  println(mat.echoWhatYouGaveMe("hello"))
  println(mat.echoWhatYouGaveMe(Nil))
  println(mat.echoWhatYouGaveMe(List(0,1,2)))
  println(mat.echoWhatYouGaveMe(List(1,2)))
  println(mat.echoWhatYouGaveMe(List(1,2,3)))
  println(mat.echoWhatYouGaveMe(Vector(1,2,3)))
  println(mat.echoWhatYouGaveMe((1,2)))
  println(mat.echoWhatYouGaveMe((1,2,3)))
  println(mat.echoWhatYouGaveMe(Person("Melissa","Alexander")))
  println(mat.echoWhatYouGaveMe(Dog("Suka")))
  println(mat.echoWhatYouGaveMe("Hello, world!"))
  println(mat.echoWhatYouGaveMe(42))
  println(mat.echoWhatYouGaveMe(42f))
  println(mat.echoWhatYouGaveMe(Array(1,2,3)))
  println(mat.echoWhatYouGaveMe(Array("coffee","apple pie")))
  println(mat.echoWhatYouGaveMe(Dog("Fido")))
  println(mat.echoWhatYouGaveMe(List("apple","banana")))
  println(mat.echoWhatYouGaveMe(Map(1->"Al",2->"Alexander")))
  println(mat.echoWhatYouGaveMe("33d"))
  println(mat.echoWhatYouGaveMe(List(2,3,4,5)))

}
