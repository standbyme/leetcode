class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def plus(x: Int, y: Int): (Int, Int) = {
    // (current,curry)
    val sum = x + y
    (sum % 10, sum / 10)
  }

  def make_list(node: ListNode): List[Int] = {
    if (node == null) Nil
    else node.x :: make_list(node.next)
  }

  def helper(list: List[Int], curry: Int): (List[Int], Int) = {

  }


  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    make_list(l1).zipAll(make_list(l2), 0, 0).foldLeft((Nil[List], 0))(helper)
  }
}