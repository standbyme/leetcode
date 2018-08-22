package p122

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    var profit = 0
    val len = prices.length
    len match {
      case 0 | 1 => 0
      case _ => {
        for (i <- 0 until (len - 1)) {
          val d = prices(i + 1) - prices(i)
          if (d > 0) profit = profit + d
        }
        profit
      }
    }
  }
}

object main extends App{
  Solution.maxProfit(Array(0,2,6))
}