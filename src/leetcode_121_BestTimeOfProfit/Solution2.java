package leetcode_121_BestTimeOfProfit;

//  思路二： dp;动态规划；
//

public class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        // 定义dp数组；dp[i][0] 代表第 i+1 天持有股票；
        //            dp[i][1] 代表第 i+1 天不持有股票；
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i<len;i++){
            // 第 i+1 天不持有股票，两种可能，1. 第 i 天就不持有，2.第 i+1 天卖掉；
            // dp[i][0] 表示某一天不持有股票，找最大值，实际上就是比较在之前卖和今天卖的较大值，也就是到当天买卖股票收益的最大值；
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            // 第 i+1 天持有股票，两种可能，1. 前面已经买了，2. 当天买的；
            // 因为dp[i][1] 表示某一天买入，一定是负值，找较大值，实际上就是找一个买入价格更低的一天；
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[len-1][0];
    }
}
