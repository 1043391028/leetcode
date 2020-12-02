package leetcode_279_absolutSquareNum;

//   题目: 完全平方数;
//   描述: 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 示例 1:
//        输入: n = 12
//        输出: 3
//        解释: 12 = 4 + 4 + 4.
//   思路: 动态规划;(和找零钱问题类似)
public class Solution1 {
    public int numSquares(int n) {
        // 新建dp[]数组,保存各个数对应的最小平方数个数;
        int[] dp = new int[n+1];
        dp[0] = 0;// 这里可以省略,dp[0]本身默认就是0;
        for(int i= 1; i<=n; i++){
            dp[i] =i;
            for(int j=1;j*j <= i;j++){
                // 转移方程;用当前数 i 依次减去从 0 开始的平方数(该步骤表示 i 包含的一个平方数) + dp[i-j(选定的数)*j]
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
