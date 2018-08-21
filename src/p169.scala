package p169

object Solution {
  def helper(tup: (Int, Int), v: Int): (Int, Int) = {
    val (prev, counter) = tup
    if (counter == 0) (v, 1)
    else if (prev == v) (prev, counter + 1)
    else (prev, counter - 1)
  }

  def majorityElement(nums: Array[Int]): Int = {
    nums.foldLeft((0, 0))(helper)._1
  }
}