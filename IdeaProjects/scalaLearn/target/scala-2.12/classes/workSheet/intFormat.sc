import java.util.{Currency, Locale}

val pi = scala.math.Pi
println(f"$pi%1.5f")
f"$pi%08.5f"
//整数部分的格式化数值(a)大于数值字符个数(b)时默认填充的个数为(a-b),否则为a-整数位字符数
f"$pi%06.2f"
"%06.2f".format(pi)
val formatter = java.text.NumberFormat.getIntegerInstance()
formatter.format(100000)
val locale = new Locale("de","DE")
val formatter2 = java.text.NumberFormat.getIntegerInstance(locale)
val formatter3 = formatter2.format(1000000)
val formatter4 = java.text.NumberFormat.getCurrencyInstance
formatter4.format(1234.56789)
val de = Currency.getInstance(new Locale("de","DE"))
formatter4.setCurrency(de)
println(formatter4.format(123789.456))