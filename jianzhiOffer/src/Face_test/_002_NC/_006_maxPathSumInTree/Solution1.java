package src.Face_test._002_NC._006_maxPathSumInTree;

//  题目： 最大路径和；
//  描述： 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少。
//          这个路径的开始节点和结束节点可以是二叉树中的任意节点
//
// 思路一： 递归；
//
public class Solution1 {
    //  初始化最大值：必须为最小负数；这一步不能少；
    private int res = Integer.MIN_VALUE;
    public int maxPathSum (TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        // 选择左子树或者右子树：<0 则返回0，表示不选择；
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        // max ： 左右子树路径和 较大的分支；
        int max = Math.max(left,right);
        // 核心和难点：
        //      max +root.val ： 表示选择左右子树其中一个较大的分支路径；
        //      root.val + left + right : 表示以当前结点和左右结点做路径的和；
        res = Math.max(res,Math.max(max+root.val,root.val + left + right));
        return max+root.val;
    }

    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }
}
