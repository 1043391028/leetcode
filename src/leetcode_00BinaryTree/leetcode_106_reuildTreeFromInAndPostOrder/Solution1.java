package leetcode_00BinaryTree.leetcode_106_reuildTreeFromInAndPostOrder;

//    题目:  根据一棵树的中序遍历与后序遍历构造二叉树。
//
//    注意:
//          你可以假设树中没有重复的元素。

public class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
          return help(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode help(int[] inorder,int inStart,int inEnd,int[] postorder,int pStart,int pEnd){
        if(pStart >pEnd ) return null;

        int index = 0;
        //再中序数组中遍历找到与后续数组最后一个元素相等的元素下标;
        for(int i = inStart;i <= inEnd;i++){
            if(inorder[i] == postorder[pEnd]){
                index = i;
                break;
            }
        }
        int left = index - inStart;
        TreeNode root = new TreeNode(postorder[pEnd]);

        root.left = help(inorder,inStart,index - 1,postorder,pStart,pStart+left-1);
        root.right = help(inorder,index + 1,inEnd,postorder,pStart + left,pEnd-1);
        return root;
    }
}
