package leetcode001_DP.leetcode_053_maxSubArray;

//  题目: 求数组最大子序列和;
//  描述: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//  示例:
//        输入: [-2,1,-3,4,-1,2,1,-5,4]
//        输出: 6
//  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//   思路一: dp;(也可以不用dp)

public class Solution1 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i =1;i<len;i++){
            // 转移方程; 当前值前元素的最大和dp[i]取决于当前值和前面的dp[i-1];
            //  但是,如果dp[i-1]<0,则舍弃,从新开始计算;
            dp[i] = nums[i] + Math.max(dp[i-1],0);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
