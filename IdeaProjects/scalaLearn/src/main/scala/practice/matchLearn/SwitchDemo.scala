package practice.matchLearn

import scala.annotation.switch

class SwitchDemo {
  val i = 1
  val x = (i: @switch) match {
    /**优化
      * 匹配的值一定是整数
      * 匹配表达式必须简单
      * 保证表达式在编译时的值可用
      * 至少包含两个case语句
      */
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

}