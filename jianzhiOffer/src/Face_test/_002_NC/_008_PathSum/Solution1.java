package src.Face_test._002_NC._008_PathSum;

//  题目： 二叉树中和为指定值所有路径；
//  描述： 给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
//
//   思路一：
//          DFS；

import java.util.ArrayList;

public class Solution1 {
    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root,res,new ArrayList<>(),sum);
        return res;
    }
    public void dfs(TreeNode root,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int target){
//      ******注意： 递归出口必须为 root == null;******
        if(root == null) return ;
        //  判断当前结点是否符合条件，并结束当前递归；
        if(root.left == null && root.right == null && target == root.val){
            // 将当前结点值加入链表；
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return ;
        }
        //if(target < 0) return;
        //  分别递归进入左右结点；
        list.add(root.val);
        dfs(root.left,res,list,target-root.val);
        dfs(root.right,res,list,target-root.val);
        list.remove(list.size()-1);
    }
}
