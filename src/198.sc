def rob(nums: Array[Int]): Int = {
  val len = nums.length
  if (len == 0) 0
  else if (len == 1) nums.head
  else {
    val result = new Array[Int](len + 1)
    result(0) = 0
    result(1) = nums(0)
    for (i <- 2 to len) {
      result(i) = math.max(result(i - 1), result(i - 2) + nums(i - 1))
    }
    result.last
  }
}

