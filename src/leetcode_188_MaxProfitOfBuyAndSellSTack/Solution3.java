package leetcode_188_MaxProfitOfBuyAndSellSTack;

//  思路三： dp动态规划；
////        空间优化在思路四；

public class Solution3 {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        // 下面表示可进行无数次的情况；在思路二中有解释；
        if(k >= len/2){
            int dp0 = 0, dp1 = -prices[0];
            for(int i = 1;i<len;i++){
                dp0 = Math.max(dp0,dp1 + prices[i]);
                dp1 = Math.max(dp1,dp0 - prices[i]);
            }
            return dp0; // 最后最大值肯定是未持有股票的情况；
        }
        // 理解的核心要点：
        //     dp[i][j][k] 只是表示某一天（具体第 i+1 天）买入和卖出的状态最大值，
        //       这个最大值dp[i][j][k]是在前一天 dp[i-1][][]的基础上得到的,而且在这个过程中只保留最大值；
        //         实际上对应的实际情况就是： 在第 i+1 天选择 买 还是 卖 ；
        int[][][] dp = new int[len][k+1][2];
        for(int i =0;i <= k;i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for(int i = 1;i < len;i++){
            for(int j = 1;j <= k;j++){
                // 第 j 次买入状态；1.第 i-1 天就是买入状态；2.第 i-1 天未买入状态，当天买入；
                dp[i][j-1][1] = Math.max(dp[i-1][j-1][1],dp[i-1][j-1][0] - prices[i]);
                // 第 就次卖出的状态；1. 第 i-1 天就是卖出 j 次状态；2.第 i-1 天持有并且是交易 j-1 次，当天卖出；
                dp[i][j][0] = Math.max(dp[i-1][j][1],dp[i-1][j-1][1] + prices[i]);
            }
        }
        return dp[len-1][k][0];
    }
}
