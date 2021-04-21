package src.Face_test._001_MostPopular._025_isBalanceTree;

//  题目： 平衡二叉树；
//  描述： 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//           在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
//           平衡二叉树（Balanced Binary Tree），具
//     有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

public class Solution1 {
    public class TreeNode{
        private int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left-right)>1?false:true;
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return 1+Math.max(left,right);
    }

}
