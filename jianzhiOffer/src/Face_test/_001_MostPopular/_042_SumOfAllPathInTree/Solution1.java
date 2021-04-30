package src.Face_test._001_MostPopular._042_SumOfAllPathInTree;

//  题目： 二叉树所有路径的和；
//  描述： 给定一个仅包含数字\ 0-9 0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
//           例如根节点到叶子节点的一条路径是1\to 2\to 31→2→3,那么这条路径就用\ 123 123 来代替。
//           找出根节点到叶子节点的所有路径表示的数字之和
//  思路一：
//         dfs;

public class Solution1 {
    public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
    }


    private int sum = 0;
    public int sumNumbers (TreeNode root) {
        // write code here
        if(root == null) return 0;
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode root,int num){
        num = num*10 + root.val;
        if(root.left == null && root.right == null){
            sum += num;
        }
        if(root.left != null) dfs(root.left,num);
        if(root.right != null) dfs(root.right,num);
    }

}
