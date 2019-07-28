val r = scala.util.Random
r.nextInt
r.nextInt(100)
r.nextFloat
r.nextDouble
r.nextPrintableChar()
var range = 0 to r.nextInt(10)
range.length
for (i <- 0 to r.nextInt(10)) yield i*2
for (i <- 0 to r.nextInt(10)) yield r.nextFloat()*i
for (i <- 0 to r.nextInt(10)) yield  r.nextPrintableChar
for (i <- 1 to 5) yield r.nextInt(100)