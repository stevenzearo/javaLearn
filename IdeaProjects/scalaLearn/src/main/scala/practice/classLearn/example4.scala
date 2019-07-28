package practice.classLearn

class Brain private {
  val head = toString
  override def toString = "This is the brain."
}

//伴生对象的作用,创建与java静态方法等效的方法
object Brain {
  val brain = new Brain
  def getInstance = brain
}

class Brain2{
  val brain = toString;
  override def toString = "This is a brain."
}
object SingletonTest extends App {
  val brain = Brain.getInstance
  println(brain)
  val b2 = new Brain2
  println(b2.brain)
  val b3 = new Brain
}