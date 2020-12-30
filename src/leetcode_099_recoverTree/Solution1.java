package leetcode_099_recoverTree;

//  题目: 恢复二叉搜索树;
//  描述: 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
//        进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
//  思路一: 递归;
//          中序遍历树, 找到第一个异常结点(当前结点值 < 前一个结点) 前一个结点就是异常结点;
//               第二个异常结点是 (当前结点 < 前一个结点) 当前结点异常;

public class Solution1 {
    public TreeNode preNode = null;
    public TreeNode lastNode = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        searchNode(root);
        int temp = preNode.val;
        preNode.val = lastNode.val;
        lastNode.val = temp;
    }
    public TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void searchNode(TreeNode root){
        if(root == null) return;
        searchNode(root.left);
        // 当遍历当前结点的前一个结点大于当前结点,说明前一个结点位置异常;
        if(root.val < pre.val && preNode == null) preNode = pre;
        // 已经存在一个异常结点前提下, 当前结点小于前结点,说明当前结点位置异常;
        if(root.val < pre.val && preNode != null) lastNode = root;
        pre = root;
        searchNode(root.right);
    }
}
