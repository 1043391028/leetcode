package leetcode_322_minNumOfCoin;

//    题目： 零钱兑换；
//    描述： 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
//           如果没有任何一种硬币组合能组成总金额，返回 -1。
//    注意：  你可以认为每种硬币的数量是无限的。
//
//    思路：Dp,动态规划；

import java.util.Arrays;

public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
//      为数组赋初始值，赋值为最大即可；
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 遍历确定dp[i] 即金钱数额从0-amount的状态
        for(int i = 1; i <= amount;i++){
            //选择某一个转换到下一个状态，并且保存中间最佳的选择（此题是选择最小零钱数的值）
            for(int coin : coins){
                if((i - coin) < 0) continue; // 说明不存在下一个转换的状态
                dp[i] = Math.min(dp[i],1 + dp[i-coin]);
            }
        }

        //判断是否存在可以换零钱的结果；也就是是否经过了循环并更新了值；
        return dp[amount] == amount+1 ? -1:dp[amount];
    }
}
