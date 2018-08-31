package p654


class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}

object Solution {
  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
    if (nums.isEmpty) null
    else {
      val max = nums.max
      val (left, right_with_root) = nums.span(_ != max)
      val right = right_with_root.tail
      val root = new TreeNode(max)
      root.left = constructMaximumBinaryTree(left)
      root.right = constructMaximumBinaryTree(right)
      root
    }
  }
}