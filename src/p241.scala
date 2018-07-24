package p241

import scala.collection.mutable.Map


object Solution {
  private val cache = Map[String, List[Int]]()

  def get_op(char: Char): (Int, Int) => Int = {
    char match {
      case '+' => _ + _
      case '-' => _ - _
      case '*' => _ * _
    }
  }

  def diffWaysToCompute(input: String): List[Int] = {
    try {
      List(input.toInt)
    } catch {
      case e: Exception => {
        cache.getOrElseUpdate(input, {
          val input_arr = input.split("(?<=\\+)|(?=\\+)|(?<=\\*)|(?=\\*)|(?<=-)|(?=-)")
          println(input_arr)
          val input_len = input_arr.length
          (1 until input_len by 2).flatMap(i => {
            val op = get_op(input_arr(i)(0))
            for {x <- diffWaysToCompute(input_arr.slice(0, i).toString); y <- diffWaysToCompute(input_arr.slice(i + 1, input_len).toString)} yield op(x, y)
          }).toList
        })
      }
    }
  }
}

object main extends App{
  println(Solution.diffWaysToCompute("10+5"))
}