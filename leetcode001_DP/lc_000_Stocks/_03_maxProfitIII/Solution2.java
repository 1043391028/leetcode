package lc_000_Stocks._03_maxProfitIII;

// dp（动态规划）;
//
// 第一版（定义三维数组）： 效率低；
//     dp[i][j][k] : i  表示第 i+1 天； j 表示进行几次交易； k 表示股票持有的状态：1 持有，0 不持有；
public class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        // 初始化第一天状态：
        //   dp[0][1][1]: 表示 第一天进行1次交易：且持有状态，买入股票 -prices[i];
        //   dp[0][2][1]: 表示第一天进行2次交易： 且持有状态，初始化为最小值是因为转移方程中：
        //                 dp[i][2][1] 可以由上个状态转移过来 -prices[i] ，取最大值，防止影响；
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;

        for(int i = 1;i<len;i++){
            dp[i][1][1] = Math.max(-prices[i], dp[i-1][1][1]);
            dp[i][1][0] = Math.max(dp[i-1][1][1]+prices[i], dp[i-1][1][0]);
            dp[i][2][1] = Math.max(dp[i-1][1][0]-prices[i], dp[i-1][2][1]);
            dp[i][2][0] = Math.max(dp[i-1][2][1]+prices[i],dp[i-1][2][0]);
        }
        return Math.max(dp[len-1][1][0],dp[len-1][2][0]);
    }
}
