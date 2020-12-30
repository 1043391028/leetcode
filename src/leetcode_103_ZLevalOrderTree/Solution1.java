package leetcode_103_ZLevalOrderTree;

//   题目: 二叉树的锯齿形遍历;
//   描述: 给定一个二叉树，返回其节点值的锯齿形层序遍历。
//        （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

import java.util.ArrayList;
import java.util.List;

//   思路一: dfs遍历;
public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root,res,0);
        return res;
    }
    // 深度遍历;遍历的时候在不同层依次加入;
    //  level 可以标记第几层,从而在深度遍历每一层都能正确的将该层的结点值加进去
    //  level%2 表示添加的顺序,头插 或者 尾插, 从而决定层序遍历是从前往后还是从后往前;
    public void dfs(TreeNode root,List<List<Integer>> res,int level){
        if(root == null) return;
        if(level == res.size()){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        if(level%2 == 0){
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0,root.val);
        }

        dfs(root.left,res,level+1);
        dfs(root.right,res,level+1);
    }
}
