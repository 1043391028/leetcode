package leetcode000_BinaryTree.leetcode_617_mergeBinaryTree;

//  题目: 合并二叉树;
//  描述: 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
//        你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
//        否则不为 NULL 的节点将直接作为新二叉树的节点。
//
//  思路: 简单递归;

public class Solution1 {
    // 1.在原结点修改;
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // if(t1 == null && t2 == null) return null;
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val += t2.val;

        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
    // 2. 新建结点,不修改原结点;
    // public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    //         if (t1 == null && t2 == null) {
    //            return null;
    //        }
    //        // 先合并根节点
    //        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
    //        // 再递归合并左右子树
    //        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
    //        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
    //        return root;
    // }
}
