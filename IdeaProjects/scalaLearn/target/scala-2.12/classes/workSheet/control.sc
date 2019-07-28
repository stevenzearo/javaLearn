val ls = List("a","b","c","d")
for (n <- ls) yield n.toUpperCase
val a = Array("apple","banana","orange")
for (e <- a) print(e+"\t")
for (e <- a) {val s = e.capitalize; print(s+"\t")}
val newArray = for (e <- a) yield e.toUpperCase
for (i <- 0 until a.length) println(s"$i is ${a(i)}")
for ((e,count) <- a.zipWithIndex) {
  println(s"$count is $e")
}
for (i <- 1 to 3) print(i)
for (i <- 1 until 3) print(i)
for (i <- 1 to 10 ) {if (i < 5) print(i) else print(-i)}
for (i <- 1 to 10 if i < 5) print(i)
val names = Map("fname" -> "steve", "lname" -> "zou")
for ((k,v) <- names) println(s"key: $k\tvalue: $v")
val ls2 = List(1,2,3)
ls2.foreach(i => println(i))
var r1 = 0
ls2.foreach(i => r1 = i)
for (i <- ls2 if i < 2) print(i)
//上下两句等价
ls2.withFilter(_ < 2).foreach(i => print(i))
ls2.map(_*1)
//多层循环
for (i <- 1 to 2; j <- 1 to 2) println(s"i = $i\tj = $j")
val array:Array[Int]
