//class UpperTriangularMatrix(size: Int) {
//  def index(x: Int)(y: Int): Int = {
//    (x * size + y) - ((x * (x + 1)) / 2)
//  }
//
//  private val bound = size - 1
//  private val len = index(bound)(bound) + 1
//  val array = new Array[Option[Int]](len)
//
//  def apply(x: Int)(y: Int): Option[Int] = {
//    val i = index(x)(y)
//    array(i)
//  }
//
//  def set(x: Int)(y: Int)(value: Option[Int]): Unit = {
//    val i = index(x)(y)
//    array(i) = value
//  }
//}