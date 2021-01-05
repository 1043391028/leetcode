package leetcode_111_minDepthOfTree;

//  题目： 二叉树的最小深度；
//  描述： 给定一个二叉树，找出其最小深度。
//
//        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//  说明：叶子节点是指没有子节点的节点。

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

      public int minDepth(TreeNode root) {
          if(root == null) return 0;
          if(root.left == null && root.right != null) return 1+minDepth(root.right);
          if(root.right == null && root.left != null) return 1+minDepth(root.left);
          int left = minDepth(root.left);
          int right = minDepth(root.right);
          return Math.min(left,right) +1;
      }
  }
}
