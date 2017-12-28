class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) null
    else {
      val node = new TreeNode(root.value)
      node.right = invertTree(root.left)
      node.left = invertTree(root.right)
      node
    }
  }
}