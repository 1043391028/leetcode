package lc_000_Stocks._02_maxProfitII;

// 思路二： 动态规划；

public class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 新建dp[][] 数组，dp[i][0] : 第 i+1 天 不持有股票的状态（卖出，或者本来就不持有）
        //                 dp[i][1] : 第 i+1 天 持有股票的状态，（买入，或者本来就有）
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for(int i = 1;i<len;i++){
            dp[i][0] =  Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }
}
