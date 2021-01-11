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
                // 下面表示d第 j（1 -> k） 次买入和卖出；
                // dp[j-1][1]表示第 j 次买入，因为买入不算交易次数，所以
                dp[j-1][1] = Math.max(dp[j-1][1],dp[j-1][0] - prices[i]);
                // dp[j][0] 表示第 j 次卖出,卖出状态会改变，所以用dp[j][0]表示，如果卖出状态不变，那么应该是dp[i-1][0];
                dp[j][0] = Math.max(dp[j][0],dp[j-1][1] + prices[i]);
            }
        }
        return dp[k][0];
    }
}
//   简洁版：(其实和思路5一样)
//     public int maxProfit(int k, int[] prices) {
//        if(prices == null || prices.length == 0) return 0;
//        int len = prices.length;
//        // 下面表示可进行无数次的情况；在思路二中有解释；
//        if(k >= len/2){
//            int dp0 = 0, dp1 = -prices[0];
//            for(int i = 1;i<len;i++){
//                dp0 = Math.max(dp0,dp1 + prices[i]);
//                dp1 = Math.max(dp1,dp0 - prices[i]);
//            }
//            return dp0; // 最后最大值肯定是未持有股票的情况；
//        }
//        int[][] dp = new int[k+1][2];
//        for(int i =0;i <= k;i++){
//            dp[i][0] = 0;
//            dp[i][1] = -prices[0];
//        }
//        for(int i = 1;i < len;i++){
//            for(int j = 1;j <= k;j++){
                  //  这里的max 中的 dp[j][] 代表的是上一天的状态，因为刚进如循环；
//                        卖出放在前面，说明最后一天只有卖出状态没有买入状态，
//                dp[j][0] = Math.max(dp[j][0],dp[j][1] + prices[i]);
                  // 代表买入状态才会发生改变，从上一个状态转移过来；
//                    （另外一层理解：只有上一次交易（卖出）过后才能进行买入操作；这里max中的dp[j-1][0]代表的是第i-1天的卖出）
//                dp[j][1] = Math.max(dp[j][1],dp[j-1][0] - prices[i]);
//            }
//        }
//        return dp[k][0];
//    }
