package leetcode_107_binaryLevelOrder;

//  题目: 二叉树的层序遍历2;
//  描述: 给定一个二叉树，返回其节点值自底向上的层序遍历。
//        （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//  思路:
//         层序遍历,
//
//         结果利用双端链表LinkedList 保存,把每一层遍历得到的 临时 list 添加到结果字符串的第一个位置;
//           这样最终结果保存的就是从底向上遍历的串;

import java.util.*;

public class Solution1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        // 新建链表保存每一层遍历的结点;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 遍历队列,直到所有队列为空;
        while(!queue.isEmpty()){
            // size保存每一层结点数量
            int size = queue.size();
            // 暂时保存该层结点值的临时链表,一会遍历完该层添加进结果res;
            List<Integer> list = new ArrayList<>();
            // 遍历当前层结点,并把下一层结点添加进队列;
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            res.addFirst(list);
        }
        return res;
    }

}
