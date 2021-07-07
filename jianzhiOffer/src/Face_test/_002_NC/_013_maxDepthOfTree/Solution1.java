package src.Face_test._002_NC._013_maxDepthOfTree;

//   题目： 二叉树最大深度；
//   描述： 求给定二叉树的最大深度，
//          最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
//   思路一：
//          递归；

public class Solution1 {
    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }

    public int maxDepth (TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
