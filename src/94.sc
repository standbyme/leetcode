class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def preorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else (root.value :: Nil) ::: preorderTraversal(root.left) ::: preorderTraversal(root.right)
  }
}