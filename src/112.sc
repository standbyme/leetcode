class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def plus(x: Int, y: Int): (Int, Int) = {
    val sum = x + y
    (sum % 10, sum / 10)
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

  }
}