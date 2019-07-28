package practice.classLearn
class Person(var firstName:String, var lastName:String){
  /**
    * this 调用主构造函数,类的主体,默认调用this.toString
    */
  println("the constructor begins")
  private val HOME = System.getProperty("user.home")
  var age = 0
  def printName = {println(this)}
  def printHome: Unit = {println(s"HOME = $HOME")}
  override def toString = "hello"
  def  printFullName {println(this)}
  printHome
  printFullName
  println("still in constructor")
}

object PersonObject extends App{
  val p = new Person("Adam", "Meyer")
//  p.age = 30
//  上下两种表达作用相同
  p.age_$eq(23)

  println(p.age)
}