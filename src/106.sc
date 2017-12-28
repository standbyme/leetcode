class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

class Solution {
  def buildTreeH(inorder: List[Int], postorder: List[Int]): TreeNode = {
    if (inorder == Nil) null
    else {
      val postorder_left_right :+ root = postorder
      val (inorder_left, inorder_root_right) = inorder.span(_ != root)
      val inorder_right = if (inorder_root_right == Nil) Nil else inorder_root_right.tail
      val (postorder_left, postorder_right) = postorder_left_right.span(!inorder_right.contains(_))
      val t = new TreeNode(root)
      t.left = buildTreeH(inorder_left, postorder_left)
      t.right = buildTreeH(inorder_right, postorder_right)
      t
    }
  }

  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = buildTreeH(inorder.toList, postorder.toList)
}

val a = new Solution
a.buildTree(Array(1, 2), Array(2, 1))