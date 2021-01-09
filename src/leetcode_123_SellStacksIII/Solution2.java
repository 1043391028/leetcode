package leetcode_123_SellStacksIII;

//  思路二： 常规暴力解法；
//           dfs; 超出时间限制；

public class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        return dfs(prices,0,0,0);
    }
    // dfs(); inrdex 表示数组下标，count表示交易次数，hold表示是否持有股票，代表0不持有，1代表持有；
    public int dfs(int[] prices,int index,int count,int hold){
        if( index >= prices.length || count == 2 && hold == 0) return 0;
        // 如果不持有，可以继续选择不持有（不买）或者买入；
        if(hold == 0){
            return Math.max(-prices[index] + dfs(prices,index+1,count,1),dfs(prices,index+1,count,0));
        }else
            //  如果持有可以选择继续持有，或者卖出；
            {
               return Math.max(prices[index] + dfs(prices,index+1,count+1,0), dfs(prices,index+1,count,1));
            }
    }
}
