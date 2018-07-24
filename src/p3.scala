package p3


object Solution {

  def lengthOfLongestSubstring(s: String): Int = {
    val len = s.length
    var prev = 0
    var max = 1
    if (len == 0) 0
    else if (len == 1) 1
    else {
      for (x <- 0 until len) {
        prev = 1
        for (y <- x + 1 until len) {
          val value = if (prev == 0) 0
          else {
            if (s.slice(x, y).contains(s(y))) 0
            else prev + 1
          }
          prev = value
          max = max.max(value)
        }
      }
      max
    }
  }
}

object run extends App {
  println(Solution.lengthOfLongestSubstring("bbbb"))
}