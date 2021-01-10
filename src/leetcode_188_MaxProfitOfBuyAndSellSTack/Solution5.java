package leetcode_188_MaxProfitOfBuyAndSellSTack;
 //
//  思路5： 思路3,4此基础上的优化；

import java.util.Arrays;

public class Solution5 {
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
        int[] sell = new int[k];
        int[] buy = new int[k];
        Arrays.fill(buy,-prices[0]);
        for(int i = 1;i < len;i++){
            for(int j = 0; j < k; j++){
                sell[j] = Math.max(sell[j],prices[i]+buy[j]);//或者不交易，或者把当前持有股票卖出
                buy[j] = Math.max(buy[j],(j==0?0:sell[j-1])-prices[i]);//或者不交易，或者按照当前价格买入
            }
        }
        return sell[k-1];
    }
}
