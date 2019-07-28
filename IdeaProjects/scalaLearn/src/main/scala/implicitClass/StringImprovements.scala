package implicitClass
package object utils{
  implicit class StringImprovements(val s: String) {
    def repeat = s*2
    def increment = s.map(c => (c+1).toChar)
    def decrement = s.map(c => (c-1).toChar)
    def hideAll = s.replace(".","*")
    def plusOne = s.toInt + 1
    def asBoolean = s match {
      case "o" | "zero" | "" | " " => false
      case _ => true
    }
  }

}
