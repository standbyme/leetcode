package p121

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    prices match {
      case Array(one) => 0
      case m => {
        val diffs = prices.sliding(2, 1).map { case Array(one, two) => two - one }

        def helper(acc: (Int, Int), value: Int): (Int, Int) = {
          val (max_sum, sum) = acc
          val next_sum = sum + value
          if (next_sum > max_sum) (next_sum, next_sum)
          else if (next_sum < 0) (max_sum, 0)
          else (max_sum, next_sum)
        }

        diffs.foldLeft((0, 0))(helper)._1
      }
    }
  }
}

object main extends App {
  println(Solution.maxProfit(Array(1)))
}