package p63

object Solution {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    val m = obstacleGrid.length
    val n = obstacleGrid(0).length
    val matrix = Array.ofDim[Int](m, n)
    for (x <- 0 until m)
      for (y <- 0 until n) {
        val value =
          if (obstacleGrid(x)(y) == 1) 0
          else {
            if (x == 0 && y == 0) 1
            else if (x == 0) matrix(x)(y - 1)
            else if (y == 0) matrix(x - 1)(y)
            else matrix(x)(y - 1) + matrix(x - 1)(y)
          }
        matrix(x)(y) = value
      }
    matrix(m - 1)(n - 1)
  }
}

object main extends App {
  val array = Array(
    Array(0, 0, 0),
    Array(0, 1, 0),
    Array(0, 0, 0),
  )
  println(Solution.uniquePathsWithObstacles(array))
}