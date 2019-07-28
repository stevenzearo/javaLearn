for (i <- 1 to 10 if i % 2 == 0) print(i)
(1 to 10).withFilter(_ % 2 == 0).withFilter(_>3).withFilter(_<6).foreach(print(_))
for {
  i <- 1 to 10
  if i > 3
  if i < 6
  if i % 2 == 2
} print(i)
val names = Array("chris","ed","maurice")
val capNames = names.map(_.capitalize)
val capNames2 = for (e <- names) yield {e.capitalize}
var fruits = scala.collection.mutable.ArrayBuffer[String]()
fruits += "apple"
fruits += "banana"
fruits += "orange"
val out = for (e <- fruits) yield e.toUpperCase
//上下两行代码等价
val out1 = fruits.map(_.toUpperCase)