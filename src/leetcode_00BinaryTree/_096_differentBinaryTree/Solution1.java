package leetcode_00BinaryTree._096_differentBinaryTree;

//      题目：给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//            输入: 3
//            输出: 5
//      解释:
//           给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//           1         3     3      2      1
//            \       /     /      / \      \
//             3     2     1      1   3      2
//            /     /       \                 \
//            2     1         2                 3
//
//      思路： dp

public class Solution1 {
    public int numTree(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            for(int j = 0;j < i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
