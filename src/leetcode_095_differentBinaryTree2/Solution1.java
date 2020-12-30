package leetcode_095_differentBinaryTree2;

//  题目: 不同的二叉搜索树;
//  描述: 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

//  思路: 递归;


import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 0) return res;
        return returnAns(1,n);
    }
    // 遍历递归从 1 到 n 作为根节点的情况;
    public ArrayList<TreeNode> returnAns(int start,int end){
        // 新建保存不同根结点的结果;
        ArrayList<TreeNode> res = new ArrayList<>();
        // start(起始位置) > end(终点位置) 时,(也就是为空的时候)添加null;
        if(start > end){
            res.add(null);
            return res;
        }
        //  起始位置等于终点位置,只有一个结点的情况;吧该结点单独作为一个边;
        if(start == end){
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        // 从start 开始到 end依次遍历不同情况;
        // 最外层的 res 就是最终结果,分别以 1.2.3...n 为根的情况集合, 内层的 res 是求排除外层的i 所有可组合的情况;
        //  内层得到的 res 不断往上层返回;
        for(int i= start;i <= end;i++){
            // i 前面一部分为一个整体共有多少种情况;
            ArrayList<TreeNode> lefts = returnAns(start,i-1);
            // i 后面共有多少种情况;
            ArrayList<TreeNode> rights = returnAns(i+1,end);
            // 把两情况分别组合;
            for(TreeNode left : lefts){
                for(TreeNode right : rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
