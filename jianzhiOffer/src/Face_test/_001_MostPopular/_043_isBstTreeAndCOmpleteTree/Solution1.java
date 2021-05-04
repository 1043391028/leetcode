package src.Face_test._001_MostPopular._043_isBstTreeAndCOmpleteTree;

//  题目： 判断是否是搜索二叉树和完全二叉树；
//   思路一：
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }

    public boolean[] judgeIt (TreeNode root) {
        // write code here
        if(root == null) return new boolean[]{true,true};
        boolean res[] = new boolean[2];
        if(isSearchTree(root,Integer.MAX_VALUE,Integer.MIN_VALUE)) res[0] = true;
        if(isCompleteTree(root)) res[1] = true;
        return res;
    }
    // BstTree判断；
    public boolean isSearchTree(TreeNode root,int up,int low){
        if(root == null) return true;
        int val = root.val;
        if(val <= low || val >= up) return false;
        return isSearchTree(root.left,val,low) && isSearchTree(root.right,up,val);
    }
    //  完全二叉树判断；
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}
