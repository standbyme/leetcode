class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) Nil
    else List(root.value) :: mix(levelOrder(root.left), levelOrder(root.right))
  }

  def mix(x: List[List[Int]], y: List[List[Int]]): List[List[Int]] = {
    x.zipAll(y, Nil, Nil).map(m => m._1 ::: m._2)
  }
}