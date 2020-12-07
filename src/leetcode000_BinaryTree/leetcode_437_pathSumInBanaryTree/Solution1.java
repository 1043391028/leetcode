package leetcode000_BinaryTree.leetcode_437_pathSumInBanaryTree;

import java.util.HashMap;

//   题目: 路径总和3;
//   描述: 给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。
//
//         路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//         二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
//   思路: 前缀和(根节点到当前节点路径的和) + HashMap; 递归 + 回溯;

public class Solution1 {
    // 主函数
    public int pathSum(TreeNode root, int sum) {
        // HashMap 保存前缀和为某一值的某一结点;
        HashMap<Integer,Integer> map = new HashMap<>();
        // 前缀和和为 0 的结点路径为一条(没有结点的情况);如: 根节点以下某一结点的前缀和为sum(目标值),
        //  该节点减去sum = 0;表示从根节点到该节点就是和为sum 的路径;
        map.put(0,1);
        return prePathSum(root,sum,map,0);
    }
    public int prePathSum(TreeNode root,int sum,HashMap<Integer,Integer> map,int curSum){
        // 递归出口;
        if(root == null) return 0;
        // 进入该层需要做的一些操作;
        // res 保存从该结点开始一共有多少路径;
        int res = 0;
        // 更新前缀和;
        curSum += root.val;
        // 检查该结点之前的结点符合条件的;
        res += map.getOrDefault(curSum-sum,0);
        // 把该结点的前缀和保存到HashMap;
        map.put(curSum,map.getOrDefault(curSum,0) + 1);
        // 递归进入当前结点左子树,右子树;
        res += prePathSum(root.left,sum,map,curSum);
        res += prePathSum(root.right,sum,map,curSum);
        // 回溯,必须把当前结点前缀和值对应的个数-1;
        map.put(curSum,map.get(curSum)-1);
        return res;
    }
}
