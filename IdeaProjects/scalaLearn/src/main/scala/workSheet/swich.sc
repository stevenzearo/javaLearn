val i = 12
i match {
  case 1 => println("January")
  case 2 => println("February")
  case 3 => println("March")
  case 4 => println("April")
  case 5 => println("May")
  case 6 => println("June")
  case 7 => println("July")
  case 8 => println("August")
  case 9 => println("September")
  case 10 => println("October")
  case 11 => println("November")
  case 12 => println("December")
  case _ => println("Invalid month")
}
val a = 4
a match {
  case 1|3|5|7|9 => println("odd")
  case 2|4|6|8|0 => println("even")
}
i match {
  case a if 0 to 9 contains a => println("0-9 range: " + a)
  case b if 10 to 19 contains b => println("10-19 range: " + b)
  case c if 20 to 19 contains c => println("20-29 range: " + c)
  case _ => println("out of range")
}
val num = 1
num match {
  case x if x == 1 => println("one, a lonely number")
  case x if (x == 2 || x == 3) => println(x)
  case _ => println("some other value")
}
class Stock(val symbol: String, val price : Int)
val stock = new Stock("xyz",12)
stock match {
  case x if (x.symbol == "xyz" && x.price < 20) => println("buy")
  case x if (x.symbol == "xyz" && x.price >= 20) => print("sell")
  case _ => println("do nothing")
}
val x = List(1,2,3)
val y = 1::2::3::Nil
val bool = x.getClass.getName==y.getClass.getName
def listToString(list:List[String]) : String = list match {
  case s :: rest => s + " " + listToString(rest)
  case Nil => ""
}
val fruits = "Apples"::"Banana"::"Oranges"::Nil
listToString(fruits)
fruits.toString
//match-case实现求和
def mySum(list:List[Int]):Int = list match {
  case Nil => 0
  case n :: rest => n + mySum(rest)
}
//match-case实现求乘积
def multiply(list:List[Int]):Int = list match {
  case Nil => 1
  case n :: rest => n*multiply(rest)
}
val nums = List(1,2,3,4,5)
mySum(nums)
multiply(nums)