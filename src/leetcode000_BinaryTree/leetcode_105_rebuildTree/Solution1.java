package leetcode000_BinaryTree.leetcode_105_rebuildTree;

//     题目：根据一棵树的前序遍历与中序遍历构造二叉树。
//
//          注意:
//              你可以假设树中没有重复的元素。

public class Solution1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        return help(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode help(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if (preStart == preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i = inStart;i < inEnd;i++){
            if(inorder[i] == preorder[preStart]){
                index = i;
                break;
            }
        }
        int left = index - inStart;

//         下面的前序和中序都是包括左边界不包括右边界；因为循环结束的条件是preOrder == preEnd;
        root.left = help(preorder,preStart+1,preStart+left+1,inorder,inStart,inStart+left);
        root.right = help(preorder,preStart+left+1,preEnd,inorder,inStart+left+1,inEnd);
        return root;
    }
}
