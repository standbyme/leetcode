package p646

object Solution {
  def findLongestChain(pairs: Array[Array[Int]]): Int = {
    if (pairs.isEmpty) 0
    else {
      val sorted = pairs.sortBy(_ (1))
      val Array(_, two) = sorted.head

      def helper(acc: (Int, Int), value: Array[Int]): (Int, Int) = {
        val Array(one, two) = value
        val (count, pre) = acc
        if (pre < one) (count + 1, two)
        else acc
      }

      sorted.tail.foldLeft(0, two)(helper)._1 + 1
    }

  }
}

object main extends App {
  println(Solution.findLongestChain(Array(Array(3, 4), Array(1, 2), Array(2, 3))))
}