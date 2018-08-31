package p95

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}

object Solution {
  def helper(from: Int, to: Int): List[TreeNode] = {
    if (from > to) {
      val list: List[TreeNode] = List[TreeNode](null)
      list
    } else if (from == to) {
      val node = new TreeNode(from)
      val list: List[TreeNode] = List(node)
      list
    } else {
      val a = for (i <- from to to) yield {
        val left_nodes = helper(from, i - 1)
        val right_nodes = helper(i + 1, to)
        for (left_node <- left_nodes; right_node <- right_nodes) yield {
          val new_node = new TreeNode(i)
          new_node.left = left_node
          new_node.right = right_node
          new_node
        }
      }
      val b = a.toList.flatten
      b
    }
  }

  def generateTrees(n: Int): List[TreeNode] = {
    if (n == 0) List()
    else helper(1, n)
  }
}

object main extends App {
  println(Solution.generateTrees(0))
}