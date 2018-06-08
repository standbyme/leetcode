package p303

class NumArray(_nums: Array[Int]) {
  val array = _nums.scan(0)(_ + _)

  def sumRange(i: Int, j: Int): Int = {
    array(j + 1) - array(i)
  }
}