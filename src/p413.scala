package p413

object Solution {

  class UpperTriangularMatrix(size: Int) {
    def index(x: Int)(y: Int): Int = {
      (x * size + y) - ((x * (x + 1)) / 2)
    }

    private val bound = size - 1
    private val len = index(bound)(bound) + 1
    val array = new Array[Option[Int]](len)

    def apply(x: Int)(y: Int): Option[Int] = {
      val i = index(x)(y)
      array(i)
    }

    def set(x: Int)(y: Int)(value: Option[Int]): Unit = {
      val i = index(x)(y)
      array(i) = value
    }
  }

  def numberOfArithmeticSlices(A: Array[Int]): Int = {
    if (A.isEmpty) 0
    else {
      val len = A.length
      val matrix = new UpperTriangularMatrix(len)
      for (x <- 0 until len)
        for (y <- x until len) {
          val diff = y - x
          val value: Option[Int] = if (diff >= 2) {
            matrix(x)(y - 1) match {
              case Some(m) => if (m == (A(y) - A(y - 1))) Some(m) else None
              case None => None
            }
          } else if (diff == 1) Some(A(y) - A(x))
          else None
          matrix.set(x)(y)(value)
        }
      matrix.array.count(_.nonEmpty) - len + 1
    }

  }
}

object main extends App {
  println(Solution.numberOfArithmeticSlices(Array(1, 2, 3, 4)))
}
