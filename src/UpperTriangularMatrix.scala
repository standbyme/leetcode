//class UpperTriangularMatrix[T](size: Int) {
//  def index(x: Int)(y: Int): Int = {
//    (x * size + y) - ((x * (x + 1)) / 2)
//  }
//
//  private val bound = size - 1
//  private val len = index(bound)(bound) + 1
//  private val array = new Array[T](len)
//
//  def apply(x: Int)(y: Int): T = {
//    val i = index(x)(y)
//    array(i)
//  }
//
//  def set(x: Int)(y: Int)(value: T): Unit = {
//    val i = index(x)(y)
//    array(i) = value
//  }
//}
