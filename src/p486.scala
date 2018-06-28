package p486

class UpperTriangularMatrix(size: Int) {
  def index(x: Int)(y: Int): Int = {
    (x * size + y) - ((x * (x + 1)) / 2)
  }

  private val bound = size - 1
  private val len = index(bound)(bound) + 1
  private val array = new Array[Int](len)

  def apply(x: Int)(y: Int): Int = {
    val i = index(x)(y)
    array(i)
  }

  def set(x: Int)(y: Int)(value: Int): Unit = {
    val i = index(x)(y)
    array(i) = value
  }
}

object Solution {

  def PredictTheWinner(nums: Array[Int]): Boolean = {
    val nums_len = nums.length
    val dp = new UpperTriangularMatrix(nums_len)

    def is_A(m: Int, n: Int): Boolean = {
      val rest = n - m + 1
      (nums_len - rest) % 2 == 0
    }

    def symbol(boolean: Boolean): Int = if (boolean) 1 else -1

    val init_is = is_A(0, 0)
    val init_symbol = symbol(init_is)

    (0 until nums_len)
      .foreach(n => dp.set(n)(n)(init_symbol * nums(n)))
    for (offset <- 1 until nums_len)
      for (d <- 0 until (nums_len - offset)) {
        val m = d
        val n = offset + d
        val is = is_A(m, n)
        val m_val = nums(m)
        val n_val = nums(n)
        if (is) dp.set(m)(n)((dp(m)(n - 1) + n_val) max (dp(m + 1)(n) + m_val))
        else dp.set(m)(n)((dp(m)(n - 1) - n_val) min (dp(m + 1)(n) - m_val))
      }

    if (dp(0)(nums_len - 1) >= 0) true
    else false
  }
}


object main extends App {
  println(Solution.PredictTheWinner(Array(1, 1, 1)))
}