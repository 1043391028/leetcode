package leetcode000_BinaryTree.leetcode_543_diameterOfBinaryTree;

//   题目: 二叉树的直径;(类似题: 124:二叉树中的最大路径和;687:最长同值路径;)
//   描述: 给定一棵二叉树，你需要计算它的直径长度。
//         一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//   思路:
//        此题不能简单地求以根节点为基础的最大直径;而是需要遍历每个结点,可能子节点中某个结点的直径更大;
//         所以递归遍历的时候,需用一全局变量 max 不断更新遍历过程的最大值;
public class Solution1 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null ) return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root.left == null && root.right == null) return 0;
        int left = root.left == null?0:dfs(root.left)+1;
        int right = root.right == null?0:dfs(root.right)+1;
        // 每到一个结点,就把左右两子树最大直径相加和原max对比,取较大者保存更新;
        max = Math.max(left+right,max);
        // 返回左右子树其中一个较大者;
        return Math.max(left,right);
    }
}
