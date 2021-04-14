package Face_test._001_MostPopular._018_pre_in_Tail_BinaryTree;

// 题目： 实现二叉树的先序，中序，后序遍历；
//  描述： 分别按照二叉树先序，中序和后序打印所有的节点。

public class Solution1 {

    public int[][] threeOrders (TreeNode root) {
        // write code here
        int len  = getLen(root);
        int[][] res = new int[3][len];
        preOder(root,res);
        inOder(root,res);
        tailOder(root,res);
        return res;
    }
    // 获取结点个数；
    public int getLen(TreeNode root){
        if(root == null) return 0;
        return 1+getLen(root.left)+getLen(root.right);
    }
    int preIndex = 0,inIndex = 0, tailIndex = 0;
    // 先序遍历；
    public void preOder(TreeNode root,int[][] res){
        if (root == null) return ;
        res[0][preIndex++] = root.val;
        preOder(root.left,res);
        preOder(root.right,res);
    }
    // 中序遍历；
    public void inOder(TreeNode root,int[][] res){
        if(root == null) return ;
        inOder(root.left,res);
        res[1][inIndex++] = root.val;
        inOder(root.right,res);
    }
    // 后续遍历；
    public void tailOder(TreeNode root,int[][] res){
        if(root == null) return ;
        tailOder(root.left,res);
        tailOder(root.right,res);
        res[2][tailIndex++] = root.val;
    }
}
