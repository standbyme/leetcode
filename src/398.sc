class Solution(_nums: Array[Int]) {


  def getRandElemO[T](arr: Array[T]): Option[T] =
    if (arr.isEmpty) None
    else arr lift util.Random.nextInt(arr.length)

  def pick(target: Int): Int = {
    val a = _nums.zipWithIndex.collect { case (elem, idx) if elem == target => idx }
    getRandElemO(a) match {
      case Some(b) => b
      case None => 123
    }
  }

}

/**
  * Your Solution object will be instantiated and called as such:
  * var obj = new Solution(nums)
  * var param_1 = obj.pick(target)
  */