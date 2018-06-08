package p724

object Solution {
  def pivotIndex(nums: Array[Int]): Int = {
    val len = nums.length
    if (len == 0) -1
    else if (len == 1) 0
    else {
      val sums = nums.scan(0)(_ + _)
      val last_sum = sums.last
      val value_opt = (1 until sums.length).collectFirst { case index if sums(index - 1) == last_sum - sums(index) => index }
      value_opt match {
        case Some(i) => i-1
        case None => -1
      }
    }
  }
}

object main extends App {
  println(Solution.pivotIndex(Array(-1,-1,-1,0,1,1)))
}