package p14

object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) ""
    else {
      val first = strs(0)
      if (first.isEmpty) ""
      else {
        val first_char = first(0).toString
        if (strs.forall(_.startsWith(first_char))) {
          first_char + longestCommonPrefix(strs.map(_.drop(1)))
        } else ""
      }
    }
  }
}

object main extends App {
  println(Solution.longestCommonPrefix(Array("flower","flow","flight")))
}