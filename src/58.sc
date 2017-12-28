object Solution {
  def lengthOfLastWord(s: String): Int = {
    if (s.isEmpty) 0
    else {
      val list = s.split(" ").filterNot(_.isEmpty)
      if (list.isEmpty) 0 else list.last.length
    }
  }
}