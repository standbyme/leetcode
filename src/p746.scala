package p746

object Solution {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val len = cost.length
    val array_1 = new Array[Int](len)
    array_1(0) = cost(0)
    array_1(1) = cost(1)
    for (i <- 2 until len)
      array_1(i) = math.min(array_1(i - 2) + cost(i), array_1(i - 1) + cost(i))
    val array_2 = new Array[Int](len)
    array_2(0) = cost(0)
    array_2(1) = cost(1)
    for (i <- 2 until (len - 1)) {

      array_2(i) = math.min(array_2(i - 2) + cost(i), array_2(i - 1) + cost(i))
    }
    math.min(array_1.last, array_2.last)
  }
}


object main extends App {
  Solution.minCostClimbingStairs(Array(0, 0, 1, 1))
}