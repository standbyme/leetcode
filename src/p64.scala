package p64

object Solution {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length
    val matrix = Array.ofDim[Int](m, n)
    for (x <- 0 until m)
      for (y <- 0 until n) {
        val value =
          if (x == 0 && y == 0) grid(0)(0)
          else if (x == 0) matrix(x)(y - 1)
          else if (y == 0) matrix(x - 1)(y)
          else matrix(x)(y - 1) min matrix(x - 1)(y)

        matrix(x)(y) = grid(x)(y) + value
      }
    matrix(m - 1)(n - 1)
  }
}
