package leetcode_300_longestRiseSublist;

import java.util.Arrays;

//  题目： 最长上升子序列；
//  描述： 给定一个无序的整数数组，找到其中最长上升子序列的长度。
//  示例：
//         输入: [10,9,2,5,3,7,101,18]
//         输出: 4
//  解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//  说明:
//        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
//        你算法的时间复杂度应该为 O(n2) 。
//  进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
//
//  思路： dp(动态规划)，最简单，好理解，但是效率低；(时间复杂度：o(N^2))
public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            for(int j=0;j <i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                // else dp[i] = Math.max(dp[i],dp[j]);这一步不用；
            }
        }
        return dp[len-1];
    }
}
