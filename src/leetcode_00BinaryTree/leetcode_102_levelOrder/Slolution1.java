package leetcode_00BinaryTree.leetcode_102_levelOrder;

//    题目：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
//        示例：
//            二叉树：[3,9,20,null,null,15,7],
            //
            //    3
            //   / \
            //  9  20
            //    /  \
            //   15   7
            //返回其层次遍历结果：
            //
            //[
            //  [3],
            //  [9,20],
            //  [15,7]
            //]

import java.util.*;

//      思路：队列实现；

public class Slolution1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() > 0){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }

}
