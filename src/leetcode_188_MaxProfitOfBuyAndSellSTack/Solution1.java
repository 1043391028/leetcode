package leetcode_188_MaxProfitOfBuyAndSellSTack;

//  题目： 买卖股票IV；
//  描述： 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
//         设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//  思路一: 递归；（时间复杂度高）

public class Solution1 {
    public int maxProfit(int k, int[] prices) {
         if(prices == null || prices.length == 0) return 0;
         int len = prices.length;
         return dfs(prices,0,k,0,0);
    }
    // 递归函数：day: 表示递归层所表示的天数；k 是次数限制；count 表示交易的次数；state 表示状态，0未持有股票，1持有股票；
    public int dfs(int[] prices,int day,int k,int count,int state){
        // 递归结束条件；
        // 注意： 当 day >= len时，说明每一天都被访问过（不动，持有，不持有）
        if(day >= prices.length || (count == k && state == 0)){
            return 0;
        }
        // 递归进入某一天，有三种可能： 1.不动（既不买也不卖）;2.持有;3.持有.
        int a = 0,b = 0,c =0;// 分别对应三种情况；

        // 1.不动；直接进入下一层（下一天）；
        a = dfs(prices,day+1,k,count,state);
        // 2.未持有：可以买入，或者继续不持有（第一种状态：不动）；
        if(state == 0){
            b = -prices[day] + dfs(prices,day+1,k,count,1);
        }else{
            // 3.持有： 可以卖出，或者继续持有（第一种状态：不动）
            c = prices[day] + dfs(prices,day+1,k,count+1,0);
        }

        // 最后返回三种情况的最大值；
        return Math.max(a,Math.max(b,c));
        // 下面的写法时统一的一起；
//        if(state == 0){
//            return Math.max(dfs(prices,day+1,k,count,0),-prices[day] + dfs(prices,day+1,k,count,1));
//        }else {
//            return Math.max(dfs(prices, day + 1, k, count, 1), prices[day] + dfs(prices, day + 1, k, count + 1, 0));
//        }
    }
}
