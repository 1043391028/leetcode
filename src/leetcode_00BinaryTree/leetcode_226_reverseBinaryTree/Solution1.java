package leetcode_00BinaryTree.leetcode_226_reverseBinaryTree;

//    题目：翻转一棵二叉树。
//          对称反转；
//    思路一：递归；
public class Solution1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode node = null;
        node = root.left;
        root.left = root.right;
        root.right = node;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }
}
