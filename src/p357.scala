package p357

object Solution {
  val arr = Array(0, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851, 5611771, 8877691)

  def countNumbersWithUniqueDigits(n: Int): Int = {
    if (n >= 1 && n <= 10) arr(n)
    else 0
  }
}

object a extends App {
  val dp = new Array[Int](11)
  dp(1) = 10

  (2 to 10)
    .foreach(n => dp(n) = ((11 - n) to 9).product * 9 + dp(n - 1))

  dp.foreach(x => print(s"$x,"))
}