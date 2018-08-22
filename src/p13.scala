package p13

object Solution {
  val map = Array(
    ("CM", 900),
    ("CD", 400),
    ("XC", 90),
    ("XL", 40),
    ("IX", 9),
    ("IV", 4),
    ("I", 1),
    ("V", 5),
    ("X", 10),
    ("L", 50),
    ("C", 100),
    ("D", 500),
    ("M", 1000)
  )

  def romanToInt(s: String): Int = {
    if (s.isEmpty) 0
    else {
      map collectFirst {
        case (k, v) if s.startsWith(k) => (v, s.drop(k.length))
      } match {
        case Some((v, s)) => v + romanToInt(s)
        case None => throw new Exception("None")
      }
    }
  }
}

object main extends App {
  println(Solution.romanToInt("MCMXCIV"))
}
