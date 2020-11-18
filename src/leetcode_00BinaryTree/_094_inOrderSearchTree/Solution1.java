package leetcode_00BinaryTree._094_inOrderSearchTree;

//     题目：给定一个二叉树的根节点 root ，返回它的 中序 遍历。

//    思路1： 常规的中序遍历；简单好理解；

import java.util.ArrayList;
import java.util.List;

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
//    设置全局链表变量，保存中序遍历函数遍历过程的结果；
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return res;
        help(root);
        return res;
    }
//  中序遍历辅助函数；
    public void help(TreeNode root){
        if(root == null) return ;
        help(root.left);
        res.add(root.val);
        help(root.right);
    }
}
