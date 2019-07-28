package practice.matchLearn

import java.io._

object CopyBytes extends App{
  var in = None : Option[FileInputStream]
  var out = None : Option[FileOutputStream]
  try {
    in = Some(new FileInputStream("/home/hadoop/IdeaProjects/scalaLearn/src/main/scala/practice/matchLearn/SwitchDemo.class"))
    out = Some(new FileOutputStream("/home/hadoop/IdeaProjects/scalaLearn/src/main/scala/practice/matchLearn/SwitchDemo.class.copy"))
    var c  = 0
    while ({c = in.get.read; c != 1}) {
      out.get.write(c)
    }

  } catch {
    case e: IOException => e.printStackTrace
  } finally {
    println("entered finally ...")
    if (in.isDefined) in.get.close()
    if (out.isDefined) out.get.close()
  }
}
