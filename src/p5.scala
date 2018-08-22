package p5

class UpperTriangularMatrix(size: Int) {
  def index(x: Int)(y: Int): Int = {
    (x * size + y) - ((x * (x + 1)) / 2)
  }

  private val bound = size - 1
  private val len = index(bound)(bound) + 1
  val array = new Array[Option[(Int, Int)]](len)

  def apply(x: Int)(y: Int): Option[(Int, Int)] = {
    val i = index(x)(y)
    array(i)
  }

  def set(x: Int)(y: Int)(value: Option[(Int, Int)]): Unit = {
    val i = index(x)(y)
    array(i) = value
  }

  def op: (Int, Int) = {
    array.flatten.maxBy(x => x._2 - x._1)
  }
}

object Solution {
  def longestPalindrome(s: String): String = {
    val len = s.length
    len match {
      case 0 => ""
      case 1 => s
      case 2 => if (s(0) == s(1)) s else s(0).toString
      case _ => {
        val matrix = new UpperTriangularMatrix(len)
        for ((c, i) <- s.zipWithIndex) matrix.set(i)(i)(Some((i, i)))
        for ((subs, i) <- s.sliding(2, 1).zipWithIndex) {
          val value = if (subs(0) == subs(1)) Some((i, i + 1)) else None
          matrix.set(i)(i + 1)(value)
        }
        for (i <- 2 until len) {
          for (x <- 0 until (len - i)) {
            val y = x + i
            val value = matrix(x + 1)(y - 1) match {
              case Some(_) => {
                if (s(x) == s(y)) Some((x, y))
                else None
              }
              case None => None
            }
            matrix.set(x)(y)(value)
          }
        }
        val (x, y) = matrix.op
        s.slice(x, y + 1)
      }
    }
  }
}

object main extends App {
  println(Solution.longestPalindrome("abc"))
}
