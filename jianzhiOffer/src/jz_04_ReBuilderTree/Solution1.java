package jz_04_ReBuilderTree;

//  题目： 重建二叉树；
//  描述： 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//  例如，给出
//           前序遍历 preorder = [3,9,20,15,7]
//           中序遍历 inorder = [9,3,15,20,7]
//
//   思路一： 递归 + HashMap;

import java.util.HashMap;

public class Solution1 {
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        int len = preorder.length;
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return RebulidTree(preorder,0,len-1,inorder,0,len-1);
    }
    public TreeNode RebulidTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart > preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int count = map.get(root.val);
        root.left = RebulidTree(pre,preStart+1,preStart+count-inStart,in,inStart,count-1);
        root.right = RebulidTree(pre,preStart+count-inStart+1,preEnd,in,count+1,inEnd);
        return root;
    }
}
