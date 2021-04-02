package lc_000_Stocks._03_maxProfitIII;

//  买卖股票： 最多交易两次；
//   思路三：
//            dp(优化空间)： 二维数组；
//             实际上还可继续优化，为一维数组；（思路四）；

//           @param dp[i][0] ： 第 i+1 天第一次买入的最大收益；
//           @param dp[i][1] ： 第 i+1 天第一次卖出的最大收益；
//           @param dp[i][2] ： 第 i+1 天第二次买入的最大收益；
//           @param dp[i][3] ： 第 i+1 天第二次买入的最大收益；

public class Solution3 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int len = prices.length;
        int[][] dp = new int[len][4];
        //  初始化： dp[0][2] = -prices[0] 因为转移方程中的取最大值，两项有一项和该初始状态有关；
        //            如果不初始化为 -prices[0](或者Integer.MIN_VALUE) ,取最大值可能会取该初始值；
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for(int i =1;i<len;i++){
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] + prices[i]);
        }
        return dp[len-1][3];
    }
}
