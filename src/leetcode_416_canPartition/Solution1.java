package leetcode_416_canPartition;

//  题目: 分割等和子集;
//  描述: 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//  注意:
//        每个数组中的元素不会超过 100
//        数组的大小不会超过 200
//
//  思路一: dp;(未经优化过的版本)改变为背包问题;

public class Solution1 {
    public boolean canPartition(int[] nums) {
        // 定义求数组和的数sum;
        int sum = 0;
        for(int num:nums){
            sum +=num;
        }
        // 如果数组和为奇数,则不可能会分成两个和相同的数组;
        if(sum%2 == 1) return false;
        // 定义动态数组;dp[i][j] 表示前 i 个数中是否有和为 j 的数;
        int target = sum/2 , len = nums.length;
        boolean dp[][] = new boolean[len][target+1];// target+1列是因为第一列为和为0的情况;

        if(nums[0] <= target)  dp[0][nums[0]] = true;// 这一步不要也可以;

        for(int i=1;i<len;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i] == j) dp[i][j] = true;
                if(nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
}
