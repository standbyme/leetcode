package p647


object Solution {

  class UpperTriangularMatrix(size: Int) {
    def index(x: Int)(y: Int): Int = {
      (x * size + y) - ((x * (x + 1)) / 2)
    }

    private val bound = size - 1
    private val len = index(bound)(bound) + 1
    val array = new Array[Boolean](len)

    def apply(x: Int)(y: Int): Boolean = {
      val i = index(x)(y)
      array(i)
    }

    def set(x: Int)(y: Int)(value: Boolean): Unit = {
      val i = index(x)(y)
      array(i) = value
    }
  }

  def countSubstrings(s: String): Int = {
    val len = s.length
    val matrix = new UpperTriangularMatrix(len)
    for (x <- (0 until len).reverse) {
      for (y <- x until len) {
        val diff = y - x
        if (diff >= 2) {
          val value = matrix(x + 1)(y - 1)
          matrix.set(x)(y)(value && (s(x) == s(y)))
        } else if (diff == 1) {
          matrix.set(x)(y)(s(x) == s(y))
        } else {
          matrix.set(x)(y)(true)
        }
      }
    }

    matrix.array.count(identity)
  }
}


object main extends App {
  println(Solution.countSubstrings("aab"))
}