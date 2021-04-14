package Face_test._001_MostPopular._016_stockSellI;

// 题目： 买卖股票I;
//        只能买卖一次；

public class Solution1 {
    public int maxProfit (int[] prices) {
        // write code here
        if(prices == null || prices.length<2) return 0;
        int len = prices.length, min = Integer.MAX_VALUE,res = 0;
        for(int i= 0;i<len;i++){
            if(prices[i] < min){
                min = prices[i];
            }
            res = Math.max(res,prices[i]-min);
        }
        return res;
    }
}
