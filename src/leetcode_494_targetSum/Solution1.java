package leetcode_494_targetSum;

//  题目: 目标和;
//  描述: 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
//         对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
//
//         返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
//  思路: dp(可转换为类背包问题)

public class Solution1 {
    public int findTargetSumWays(int[] nums, int S) {
        // 求数组元素总和;
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        // 如果目标数绝对值大于数组元素总和,直接返回0;
        if(sum < Math.abs(S)) return 0;
        //dp[i][j] 表示元素和为 j 的前 i 个数组合情况;
        // 定义dp数组 行\列,行len = 组元素个数;列wids = 2*sum(元素和)+1;2*sum是因为可能为负值,最小为-sum;
        //  +1 是把 j= 0 的情况考虑进去;
        int len = nums.length, wids = sum*2+1;
        int[][] dp = new int[len][wids];
        // 初始化,第一个元素nums[0]可能为0;那么dp[0][sum]表示j=0;这里防止j值<0,故在dp数组第二维每个和j值+sum;
        // dp[0][sum]实际上代表的是第一个元素和为0的情况;
        if(nums[0] == 0) {
            dp[0][sum] = 2;
        }else{
            dp[0][nums[0]+sum] = 1; // 第一个元素和为nums[0]的情况;
            dp[0][sum-nums[0]] = 1; // 第一个元素和为-nums[0]的情况;
        }
        // 动态规划过程;
        for(int i = 1;i < len;i++){
            for(int j = 0;j < wids;j++){
                int m = j - nums[i] < 0?0:j-nums[i];
                int n = j + nums[i] >= wids?0:j+nums[i];
                dp[i][j] = dp[i-1][m] + dp[i-1][n]; // 转移方程;
            }
        }
        // 返回结果;
        return dp[len-1][S+sum];
    }
}
