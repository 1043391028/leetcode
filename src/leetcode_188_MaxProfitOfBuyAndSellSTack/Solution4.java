package leetcode_188_MaxProfitOfBuyAndSellSTack;

//   思路四：dp（优化）
//           因为，当天的最大值，只和前一天有关，因此可以把把第一维去掉，用len(天数)循环来求最大值；
//
//  这里运用了二维数组dp[len][2], dp[j][0] 表示第 j 次交易未持有股票状态，dp[j][1]表示第 j-1 次交易持有股票状态；
//     实际上可以用两个一维数组表示，sell[k] 表示 k 次交易卖出状态最大值，buy[k] 表示k次交易买入状态最大值；
//        具体代码见 solution5；

public class Solution4 {
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
        int[][] dp = new int[k+1][2];
        for(int i =0;i <= k;i++){
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for(int i = 1;i < len;i++){
            for(int j = 1;j <= k;j++){
                dp[j-1][1] = Math.max(dp[j-1][1],dp[j-1][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0],dp[j-1][1] + prices[i]);
            }
        }
        return dp[k][0];
    }
}
