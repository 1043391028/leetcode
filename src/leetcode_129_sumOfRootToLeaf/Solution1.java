package leetcode_129_sumOfRootToLeaf;

//  题目： 根到所有叶子结点的和；
//  描述： 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
//         例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
//         计算从根到叶子节点生成的所有数字之和。
//
//  说明: 叶子节点是指没有子节点的节点。
//
//   思路： 递归；

public class Solution1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        //  if(root == null) return 0;
        dfs(0,root);
        return sum;
    }
    public void dfs(int k,TreeNode root){
        if(root == null) return ;
        k = k*10+root.val;
        if(root.left == null && root.right == null){
            sum +=k;
        }
        dfs(k,root.left);
        dfs(k,root.right);
    }
}
