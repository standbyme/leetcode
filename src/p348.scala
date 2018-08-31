package p348

import p654.TreeNode

object Solution {
  def check(node: TreeNode): Boolean = {
    if (node == null) false
    else if (node.value == 1) true
    else check(node.left) || check(node.right)
  }

  def pruneTree(root: TreeNode): TreeNode = {
    if (check(root)) {
      val left = pruneTree(root.left)
      val right = pruneTree(root.right)
      root.left = left
      root.right = right
      root
    } else null
  }
}