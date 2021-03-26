package Face_test.zIgzagLevelOrder;

// 题目： 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
// 例如：
//        给定的二叉树是{3,9,20,#,#,15,7},

import java.util.ArrayList;
import java.util.LinkedList;

//  思路： 广度优先遍历；
//          设置标志位 flag ; 每层遍历根据标志位 利用 双向链表 LinkedList 对每层结点采用头插和尾插法；
//

public class Solution1 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode temp = queue.pollFirst();
                if(flag == 1){
                    list.add(temp.val);
                }else{
                    list.add(0,temp.val);
                }
                if(temp.left != null)queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
            res.add(list);
            flag = -flag;
        }
        return res;
    }
}
