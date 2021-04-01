package lc_000_Stocks._01_maxProfit;

// 题目： 股票最大利润；
//  描述:
//        假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

//示例 1:
//       输入: [7,1,5,3,6,4]
//       输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
//
//  思路一： 直接遍历；(实际上和动态规划思路核心一样)
//             遍历过程保存最小值和更新最大值；

//  思路二： dp(动态规划)；
//            实际上也就是思路一；
//           dp[i] 表示第 i+1 天的最大利润： dp[i] = Max(dp[i-1],prices[i] - min(prices[0~i-1]));
//                  意思也就是，当天选择 卖出（prices[i] - min(...)） 和 不卖出(dp[i-1]) 股票；

public class Solution1 {
    public int maxProfit(int[] prices) {
        int len = prices.length,min = Integer.MAX_VALUE, max = 0;
        for(int i =0;i<len;i++){
            if(min > prices[i]){
                min = prices[i];
            }
            int temp = prices[i] - min;
            max = Math.max(max,temp);
        }
        return max;
    }
}
