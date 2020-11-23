package leetcode_00BinaryTree.leetcode_114_BinaryToList;

//     题目：给定一个二叉树，原地将它展开为一个单链表。

//     思路一：倒序遍历二叉树，并且保留前一个结点，当遍历到节点时，将上一个保留的结点保存为当前节点的下一个结点；

public class Solution1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode pre = null;
    // 下面的过程就是把 中 -> 左 -> 右 的遍历顺序按右 -> 左 -> 中顺序遍历并保存上一个结点，
    // 遍历到当前结点把保存的上一个结点保存为当前结点的下一个二结点；
    public void flatten(TreeNode root) {
        if(root == null) return ;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null; // 这一步一定不能少，否则输出会有很多重复的左结点；
        pre = root;
    }
}
