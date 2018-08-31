package p96

object Solution {
  def numTrees(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 2
    else {
      val array = new Array[Int](n + 1)
      array(1) = 1
      array(2) = 2
      for (m <- 3 to n) {
        val a = 2 * array(m - 1)
        val b = for (x <- 1 to m - 2) yield {
          array(x) + array(m - x - 1)
        }
        val c = b.sum
        array(m) = a + c
      }
      array.last
    }
  }
}