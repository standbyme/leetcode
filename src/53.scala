package p53

import scala.annotation.tailrec

object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    val nums_bound = nums.length - 1

    @tailrec
    def helper(x: Int)(y: Int)(pre: Int)(max: Int): Int = {
      val num = nums(y)
      if (x == y) {
        if (x < nums_bound) helper(x)(y + 1)(num)(math.max(num, max))
        else math.max(num, max)
      } else {
        val now = pre + num
        if (y < nums_bound) helper(x)(y + 1)(now)(math.max(now, max))
        else helper(x + 1)(x + 1)(0)(math.max(now, max))
      }
    }

    helper(0)(0)(0)(nums(0))
  }
}

object run extends App {
  println(Solution.maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)))
}
