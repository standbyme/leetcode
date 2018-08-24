package p69

object Solution {
  def mySqrt(x: Int): Int = {
    var t = x.toDouble
    while ((t * t) > x) {
      t = (x / (2 * t) + t / 2).toInt
    }
    t.toInt
  }
}