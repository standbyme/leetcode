class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

class Solution {
  def buildTreeH(preorder: List[Int], inorder: List[Int]): TreeNode = {
    if (preorder == Nil) null
    else {
      val root :: preorder_left_rifht = preorder
      println(233)
      val (inorder_left, inorder_root_right) = inorder.span(_ != root)
      val _ :: inorder_right = inorder_root_right
      println(233)

      val (preorder_left, preorder_right) = preorder_left_rifht.span(inorder_right.contains)
      val t = new TreeNode(root)
      t.left = buildTreeH(preorder_left, inorder_left)
      t.right = buildTreeH(preorder_right, inorder_right)
      t
    }
  }

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = buildTreeH(preorder.toList, inorder.toList)
}

val a = new Solution
a.buildTree(Array(1, 2), Array(2, 1))