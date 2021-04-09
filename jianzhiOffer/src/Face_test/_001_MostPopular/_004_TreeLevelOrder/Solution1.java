package Face_test._001_MostPopular._004_TreeLevelOrder;

//  题目： 树的层序遍历；
//   描述：  给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
//   例如：
//         给定的二叉树是{3,9,20,#,#,15,7},
//   思路一：
//          广度优先遍历；

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution1 {
    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while(queue.size()>0){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode temp  = queue.peekFirst();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                list.add(queue.pollFirst().val);
            }
            res.add(list);
        }
        return res;
    }
}
