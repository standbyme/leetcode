package p120

object Solution {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    def fetch(i: Int, prev: List[Int]): Int = {
      if (i == 0) prev(0)
      else if (i == prev.length) prev(i - 1)
      else Math.min(prev(i - 1), prev(i))
    }

    def helper(prev: List[Int], current: List[Int]): List[Int] = {
      current
        .zipWithIndex
        .map { case (v, i) => fetch(i, prev) + v }
    }


    triangle.reduce(helper).min
  }
}