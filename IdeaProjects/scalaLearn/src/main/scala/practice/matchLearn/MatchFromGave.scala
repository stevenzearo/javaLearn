package practice.matchLearn

abstract class MatchFromGave {

  def echoWhatYouGaveMe(x:Any):String = x match {
    case 0 => "zero"
    case true => "true"
    case "hello" => "you said 'hello'"
    case Nil => "an empty List"
    case List(0,_,_) => "a three-element list whith 0 as the first element"
    case List(1,_*) => "a list beginning with 1, having any number of elements"
    case Vector(1,_*) => "a vector starting with 1, having any number of elements"
    case (a,b) => s"got $a, and $b"
    case (a,b,c) => s"got $a, $b, and $c"
    case Person(first,"Alexander") => s"found an Alexander, first name  = $first"
    case Dog("Suka") => s"found a dog named Suka"
    case s:String => s"you gave me this string: $s"
    case i:Int => s"thanks for the int: $i"
    case f:Float => s"thanks for the float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
    case d: Dog => s"dog: ${d.name}"
//    case list: List[_] => s"thanks for the list: $list"
//      注意上下两行用法的区别
    case list @ List(2,_*) => s"got a list beginning with 2, the list of ${list.mkString(",")}"
    case m: Map[_,_] => m.toString()
    case _ => "Unknown"
  }

}
case class Dog(val name: String)
case class Person(val firstName:String, val lastName:String)


