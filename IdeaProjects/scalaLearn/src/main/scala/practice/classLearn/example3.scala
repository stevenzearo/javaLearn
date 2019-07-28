package practice.classLearn
object Practice extends App{
  val p0 = new Person3("Steve", 14)
  //case类的创建实质等于同时创建类与类的伴生对象
  case class Person2(val name: String, val  age: Int)
//  创建Person2类的伴生对象
  object Person2 {
    def apply() = new Person2("<no name>", 10)
    def apply(name: String) = new Person2(name, 9)
  }
  val p = Person2("Tom", 12)
//  上下两种创建方式效果相同
  val p2 = Person2.apply("Tony",13)
  val p3 = Person2()
  val p4 = Person2("Leonard")
  println(p0.name, p0.age)
  println(p.name, p.age)
  println(p2.name, p2.age)
  println(p3.name, p3.age)
  println(p4.name, p4.age)
}
protected class Person3(val name: String, val age: Int){}

