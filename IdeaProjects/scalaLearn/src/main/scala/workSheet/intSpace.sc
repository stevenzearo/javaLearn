val r1 = 1 to 10
val r2 = 1 to 10 by 2
for (i <- 1 to 5) print(scala.util.Random.nextPrintableChar)
for (i <- 1 until 5) print(i)
val x1 = (1 to 10).toArray
val x2 = (1 to 10).toList
var range = 0 to scala.util.Random.nextInt(10)
for (i <- 1 to 5) yield (i*2).toDouble