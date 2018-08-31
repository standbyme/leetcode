package p740

object Solution {
  def deleteAndEarn(nums: Array[Int]): Int = {
    val cnt = nums.groupBy(identity).mapValues(_.size)
    val array = cnt.keys.toSeq.sorted
    val len = array.length
    len match {
      case 0 => 0
      case 1 => nums.sum
      case _ => {
        val max = array.last
        val min = array.head
        val dp = new Array[Int](max + 1)
        dp(1) = cnt.getOrElse(1,0)
        for (i <- 2 to max) {
          dp(i) = dp(i - 1) max (dp(i - 2) + (cnt.getOrElse(i,0) * i))
        }
        dp.last
      }
    }
  }
}

object main extends App {
  println(Solution.deleteAndEarn(Array(1,3)))
}