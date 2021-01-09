package leetcode_123_SellStacksIII;

//  题目：123.买卖股票III；
//  描述： 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//         设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
//  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//   思路一： dp 动态规划；
//
public class Solution1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        // dp[][4] 第二维长度 4 代表4种状态；
        int[][] dp = new int[len][4];
        // 初始化；
        dp[0][0] = -prices[0]; // 第一次买入；
        dp[0][1] = 0;          // 第一次卖出；
        dp[0][2] = -prices[0]; // 第二次买入；
        dp[0][3] = 0;          // 第二次卖出；
        // 遍历数组 规划dp;
        for(int i = 1;i<len;i++){
            // 转移方程： 每一次买入卖出都是根据上一次转变；
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] + prices[i]);
        }
        return dp[len-1][3];
    }
}

// 精简版动态规划：
//
//   class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if(len == 0) return 0;
//         int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
//         for(int i = 1;i < len; i++){
//             buy1 = Math.max(buy1, -prices[i]); // 这里的 buy1 代表再遍历的元素位置前 买入的最低价格；
//                                                      下面的sell1,buy2,sell2 也一样；
//             sell1 = Math.max(sell1,buy1 + prices[i]);
//             buy2 = Math.max(buy2, sell1 - prices[i]);
//             sell2 = Math.max(sell2,buy2 + prices[i]);
//         }
//         return sell2;
//     }
//}
