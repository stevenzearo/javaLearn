package practice.classLearn
class Pizza2(){
//  主构造函数为this()
  var crustSize = 0
  var crustType = ""
//  定义第一个辅助构造函数
  def this(crustSize:Int){
    this()
    this.crustSize = crustSize
  }
//  定义第二个辅助构造函数
  def this(crustTye:String){
    this()
    this.crustType = crustTye
  }
//  定义第三个辅助构造函数
  def this(crustSize:Int, crustType:String){
    this()
    this.crustSize = crustSize
    this.crustType = crustType

  }
}
object Pizza2 extends App{
//  通过主构造函数构造实例
  val p0 = new Pizza2()
  println(p0.crustSize, p0.crustType)
//  通过第一个辅助构造函数构造实例
  val p1 = new Pizza2(12)
  println(p1.crustSize, p1.crustType)
//  通过第二个辅助构造函数构造实例
  val p2 = new Pizza2("thin")
  println(p2.crustSize, p2.crustType)
//  通过第三个辅助构造函数构造实例
  val p3 = new Pizza2(10, "heavy")
  println(p3.crustSize, p3.crustType)
}
