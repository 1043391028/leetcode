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
        // HashMap 的作用是存储 中序遍历数组对应元素的下标；
        //    为 构建左子树和与右子树 将数组元素划分；
        for(int i = 0;i < len;i++){
            map.put(inorder[i],i);
        }
        return RebulidTree(preorder,0,len-1,inorder,0,len-1);
    }
    // 递归函数，构建根，以及左子树和右子树；
    public TreeNode RebulidTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart > preEnd) return null;
        //  前序数组第一个元素为根节点；
        TreeNode root = new TreeNode(pre[preStart]);
        /// 用 map 找到中序数组中该元素的位置index;
        int index = map.get(root.val);
        // index - instart 实际上是左子树结点数；
        root.left = RebulidTree(pre,preStart + 1,preStart +index -inStart,in,inStart,index-1);
        root.right = RebulidTree(pre,preStart + index - inStart + 1,preEnd,in,index + 1,inEnd);
        return root;
    }
}
