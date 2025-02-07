package leetcode_100_isSameTree;

//  题目: 相同的树;
//  描述: 给定两个二叉树，编写一个函数来检验它们是否相同。
//
//        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

//  思路一: 递归;

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
