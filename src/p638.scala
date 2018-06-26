package p638

import scala.collection.mutable.Map

object Solution {
  def shoppingOffers(price: List[Int], special: List[List[Int]], needs: List[Int]): Int = {
    val dp: Map[List[Int], Int] = Map()

    def solve(needs: List[Int]): Int = {
      dp.getOrElse(needs, {
        val p = price.toStream.zip(needs).map(t => t._1 * t._2).sum
        dp += (needs -> p)
        special.foreach { sp =>
          val new_needs = needs.toStream.zip(sp.init).map(t => t._1 - t._2).toList
          if (new_needs.forall(_ >= 0)) {
            val new_cost = solve(new_needs) + sp.last
            if (new_cost < dp(needs)) {
              dp += (needs -> new_cost)
            }
          }
        }
        dp(needs)
      })
    }

    solve(needs)
  }
}


object aaa extends App {
  val a = Solution.shoppingOffers(List(2, 5), List(List(3, 0, 5), List(1, 2, 10)), List(3, 2))
  println(a)
}