package leetcode_110_IsBalencedTree;

//  题目: 平衡二叉树;
//  描述: 给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//        本题中，一棵高度平衡二叉树定义为：
//
//         一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//  思路: 递归;

public class Solution1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(right-left)>1? false:isBalanced(root.left)&&isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
