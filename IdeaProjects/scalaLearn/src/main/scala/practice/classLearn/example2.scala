package practice.classLearn
class Pizza (var crustSize: Int, var crustType: String){
  def this (crustSize:Int) {
    this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
  }
  def this (crustType: String) {
    this(Pizza.DEFAULT_CRUST_SIZE, crustType)
  }
  def this (){
    this(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  }
  override def toString = s"A $crustSize inch pizza with a $crustType crust"
}
object Pizza extends App{
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "THIN"
  val p1 = new Pizza(Pizza.DEFAULT_CRUST_SIZE,Pizza.DEFAULT_CRUST_TYPE)
  println("p1 " + p1.crustSize + p1.crustType)
  val p2 = new Pizza(DEFAULT_CRUST_SIZE)
  println("p2 " + p2.crustSize + p2.crustType)
  val p3 = new Pizza(DEFAULT_CRUST_TYPE)
  println("p3 " + p3.crustSize + p3.crustType)
  val p4 = new Pizza
  println("p4 " + p4.crustSize + p4.crustType)


}