package lc_000_Stocks._03_maxProfitIII;

//  题目： 买卖股票III；
//  描述： 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//        设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
//  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//  思路一： DFS;(超时)

public class Solution1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        return dfs(prices,0,0,0);
    }
    // dfs(); inrdex 表示数组下标，count表示交易次数，hold表示是否持有股票；
    private int dfs(int[] prices, int i, int hasStock, int counts) {
        // 如果已经买了两次股票，并且手里已经没有股票了，那么后面的天数不需要考虑
        if(i >= prices.length || (counts >= 2 && hasStock < 1))
            return 0;
        // 如果手里有股票，我可以选择卖或者不卖
        if(hasStock > 0)
            return  Math.max(prices[i] + dfs(prices, i+1, 0, counts), dfs(prices, i+1, 1, counts));
        // 如果没有股票，我可以选择买或者不买
        return Math.max(-prices[i] + dfs(prices, i+1, 1, counts+1), dfs(prices, i+1, 0, counts));
    }
}

//    public int maxProfit(int[] prices) {
//        int len = prices.length;
//        if(len < 2) return 0;
//        return DFS(prices,0,0,0);
//    }
//    public int DFS(int[] prices,int index,int state,int count){
//        if(index == prices.length || count == 2) return 0;
//        if(state == 1){
//            return Math.max(prices[index]+DFS(prices,index+1,0,count+1),DFS(prices,index+1,1,count));
//        }
//        return Math.max(DFS(prices,index+1,1,count)-prices[index],DFS(prices,index+1,0,count));
//    }
