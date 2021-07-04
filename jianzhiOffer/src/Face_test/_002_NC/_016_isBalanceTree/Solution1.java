package src.Face_test._002_NC._016_isBalanceTree;

/// 题目： 判断是否是对称二叉树；
//  描述： 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）

//  思路一： 递归；
//   思路二： 迭代；

public class Solution1 {
    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }

    public boolean isSymmetric (TreeNode root) {
        if(root == null) return true;
        //if(root.left != null && root.right != null && root.left.val == root.right.val) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if(right == null && left == null) return true;
        else if(right == null || left == null) return false;
        return left.val == right.val && dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}
