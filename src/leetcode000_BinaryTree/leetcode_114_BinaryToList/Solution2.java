package leetcode000_BinaryTree.leetcode_114_BinaryToList;

//      思路2：递归，先把左子树拉直，然后把右子树拉直，然后把左子树挂到右子树，再把右子树挂到刚刚挂到右子树的末尾；

public class Solution2 {
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
    public void flatten(TreeNode root) {
        if(root == null) return ;
//        递归进入左子树、右子树；遍历完以后左子树和右子树都被”拉直了“（单个只有右子树的链表）
        flatten(root.left);
        flatten(root.right);
//       保存左子树和右子树；
        TreeNode left = root.left;
        TreeNode right = root.right;
        //        将左子树挂到右子树，并把左子树置空；
        root.right = left;
        root.left = null;
//        把右子树挂到刚刚更新的右子树末尾，形成一个只有右子树的单链表；
        TreeNode proot = root;
        while(proot.right != null){
            proot = proot.right;
        }
        proot.right = right;
    }
}
