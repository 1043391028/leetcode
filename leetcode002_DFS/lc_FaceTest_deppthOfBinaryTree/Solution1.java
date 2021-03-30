package lc_FaceTest_deppthOfBinaryTree;

//  题目： 二叉树深度；
//  描述： 求给定二叉树的最大深度，
//         最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。

public class Solution1 {
    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }


    public class Solution {
        /**
         *
         * @param root TreeNode类
         * @return int整型
         */
        public int maxDepth (TreeNode root) {
            // write code here
            if(root == null) return 0;
            int res = Math.max(maxDepth(root.left),maxDepth(root.right))+1;
            return res;
        }
    }
}
