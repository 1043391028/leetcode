package lc_000_Stocks._03_maxProfitIII;

// 思路四：
//        空间优化（实际上时间也优化了）

//          @param buy1  ： 第 i+1 天第一次买入的最大收益；
//          @param sell1 ： 第 i+1 天第一次卖出的最大收益；
//          @param buy2  ： 第 i+1 天第二次买入的最大收益；
//          @param sell2 ： 第 i+1 天第二次买入的最大收益；

public class Solution4 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int len = prices.length;
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = -prices[0];
        for(int i =1;i<len;i++){
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
