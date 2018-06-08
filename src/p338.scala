package p338

object Solution {
  def countBits(num: Int): Array[Int] = {
    num match {
      case 0 => Array(0)
      case 1 => Array(0, 1)
      case 2 => Array(0, 1, 1)
      case n => {
        val array = new Array[Int](n + 1)
        array(0) = 0
        array(1) = 1
        array(2) = 1
        var flag = 0
        for (i <- 3 to n) {
          flag = (flag + 1) % 2
          array(i) = array(i >> 1) + flag
        }
        array
      }
    }

  }
}


object main extends App {
  Solution.countBits(10).foreach(println)

}