package lc_000_Stocks._02_maxProfitII;

// 题目： 买卖股票的最佳时机；
//
// 描述：  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//         设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//  思路一： 要想利益最大，可以无限次交易，且当天卖出可以再买；
//           那么每次只要当天的股票价格低于下一天，那么就可以买卖，这样获得的利益最大；
//             因此，一次遍历数组，每次下一个数大于当天的 股票价格，就交易；
//

public class Solution1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res = 0;
        for(int i=0;i<len-1;i++){
            if(prices[i] < prices[i+1]){
                res += prices[i+1] - prices[i];
            }
        }
        return res;
    }
}
