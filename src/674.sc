class Solution {
  def helper(tup: (Int, Int, Int), current_num: Int): (Int, Int, Int) = {
    val (previous_num, previous_len, max_length) = tup
    if (current_num > previous_num) {
      val current_len = previous_len + 1
      if (current_len > max_length) (current_num, current_len, max_length + 1) else (current_num, current_len, max_length)
    } else {
      (current_num, 1, max_length)
    }
  }

  def findLengthOfLCIS(nums: Array[Int]): Int = {
    val list = nums.toList
    if (list == Nil) 0
    else {
      nums.tail.foldLeft((nums.head, 1, 1))(helper)._3
    }
  }
}

val a = new Solution
a.findLengthOfLCIS(Array(1, 3, 5, 4, 7))