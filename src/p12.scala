package p12

object Solution {
  def intToRoman(num: Int): String = {
    var result = 0
    val M = num / 1000
    result = num % 1000
    val CM = result / 900
    result = result % 900
    val D = result / 500
    result = result % 500
    val CD = result / 400
    result = result % 400
    val C = result / 100
    result = result % 100
    val XC = result / 90
    result = result % 90
    val L = result / 50
    result = result % 50
    val XL = result / 40
    result = result % 40
    val X = result / 10
    result = result % 10
    val IX = result / 9
    result = result % 9
    val V = result / 5
    result = result % 5
    val IV = result / 4
    result = result % 4
    val I = result
    "M" * M + "CM" * CM + "D" * D + "CD" * CD + "C" * C + "XC" * XC + "L" * L + "XL" * XL + "X" * X + "IX" * IX + "V" * V + "IV" * IV + "I" * I
  }
}

object main extends App {
  println(Solution.intToRoman(1994))
}