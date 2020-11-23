package leetcode_124_maxPathSum;

//   题目：给定一个非空二叉树，返回其最大路径和。
//
//        本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
//        该路径至少包含一个节点，且不一定经过根节点。
//

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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
            if(root == null) return 0;
            int max = Integer.MIN_VALUE;
            help(root);
            return max;
    }
    public int help(TreeNode root) {
        if (root == null) return 0;
        // 保存当前结点下经过 左子结点（左分支）和右子结点（右分支）的最大值；
        int left = Math.max(0, help(root.left));
        int right = Math.max(0, help(root.right));
//      遍历过程中更新保存最大值；
        max = Math.max(max, root.val + left + right);
//     返回经过当前结点路径的最大和；
        return root.val + Math.max(left, right);
    }
}
