package Face_test._001_MostPopular._017_TreeRightGraph;

//  题目： 二叉树的右视图；
//  描述： 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        List<Integer> res = new ArrayList<>();
        TreeNode root = buildeTree(xianxu,0,xianxu.length-1,zhongxu,0,zhongxu.length);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if(i == size) res.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        int[] ans = new int[res.size()];
        int index = 0;
        for(int num:res){
            ans[index++] = num;
        }
        return ans;
    }
    public TreeNode buildeTree(int[] pre,int prestart,int preend,int[] in,int instart,int inend){
        if(prestart>preend) return null;
        TreeNode root = new TreeNode(pre[0]);
        int count = 0;
        for(int num:in){
            if(num == pre[0]) break;
            count++;
        }
        root.left = buildeTree(pre,prestart+1,prestart+count,in,instart,instart+count);
        root.right = buildeTree(pre,prestart+count+1,preend,in,instart+1,inend);
        return root;
    }
}
