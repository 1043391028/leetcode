package leetcode_121_BestTimeOfProfit;

//  题目：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//        如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
//        注意：你不能在买入股票前卖出股票。
// 思路一：简单遍历；
//        遍历数组，找当前元素与之前元素最小值的差来更新MaxProfit；
//           如果当前元素为最小元素，那么就更细最小元素，接着往后遍历，因为最小元素不可能是最大利益；

public class Ssolution1 {
    public int maxProfit(int[] prices) {
        int max = 0 , min = Integer.MAX_VALUE;
        for(int i = 0 ;i < prices.length;i++){
            // 如果当前元素最小，则直接更新最小元素，并往后遍历，因为最大利益不可能是 当前元素值 - 之前某一元素值；
            if(prices[i] < min) {
                min = prices[i];
            }else {
                max = Math.max(max,prices[i]-min);
            }
        }
        return max;
    }
}
