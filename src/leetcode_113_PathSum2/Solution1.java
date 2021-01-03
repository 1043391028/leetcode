package leetcode_113_PathSum2;

// 题目: 路径总和;
// 描述: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
//  说明: 叶子节点是指没有子节点的节点。
//
//  示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
// 思路一:  相当于结点的前序遍历;先减去当前结点值,然后递归进入左右子节点;
//            递归结束条件是,当前结点左右子节点为空,且和减去当前结点值结果为0;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root,res,sum,new ArrayList<Integer>());
        return res;
    }
   // res 保存结果; sum 为遍历到当前结点剩余的和(减去遍历过结点的值后); path 保存经历过的结点(路径);
    public void dfs(TreeNode root,List<List<Integer>> res,int sum,List<Integer> path){
        // 如果遍历到空结点,返回;
        if(root == null) return ;
        // 判断当前结点是否符合路径条件;(子节点为空且sum减去该节点值后为0);
        // if语句只是为了判断当前结点是否符合条件,符合人就加入结果,同时要删除当前结点,结束当前层循环;
        if(sum-root.val == 0){
            if(root.left == null&& root.right ==null) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
            // return ; 这一步一定不能有,sum 如果为负数. 到某一个非叶子节点即使等于0也不能返回;
        }
        // 当前层不符合条件,要把该层结点值减去,并接入路径;
        path.add(root.val);
        sum -= root.val;
        // 递归进入左右子节点;
        dfs(root.left,res,sum,path);
        dfs(root.right,res,sum,path);
        // 移去当前层加入夫人结点, 可以理解为回溯;
        // 这里并不关心子节点,只是当前层的移除, 子节点的递归自然有子节点回溯;
        path.remove(path.size()-1);
    }
}
