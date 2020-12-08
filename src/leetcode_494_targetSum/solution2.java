package leetcode_494_targetSum;

/// 思路2: 巧妙的转换为 01 背包问题;
//
// 问题转化：num 与 -num 选择哪一个结果相差 2*num
//           将 num -num 映射为 2*num  0
//           将 nums 中的每个 num 转换成 2*num，操作为取或不取
//           S 的范围是 -sum(nums) ~ sum(nums), 对 num 做映射之后，S 的范围也发生了变化: 0~2*sum(nums)
//           因此，S -> S+sum(nums)，完成 S 的映射
//           现在是标准的 01 背包 问题

public class solution2 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            nums[i] += nums[i]; // 每一个数都*2;
        }
        if(S>sum) return 0;
        S += sum; // 结果 +sum(总和);
        int[] dp = new int[S+1];// 动态数组,dp[i] 表示背包里占用容量为i;
        dp[0] = 1; // dp[0]背包为0,说明第一个不选;
        for(int num: nums){
            for(int i=S; i>=0; i--){  // 优化空间了,必须从后往前动态更新
                if(i-num>=0){
                    dp[i] = dp[i] + dp[i-num]; // 优化空间了;只保存了上一行数据
                    // dp[i]表示本行不选该数,上一行背包容量为i;dp[i-num] 表示本行选择该数,那么上一行背包容量就剩i-num;
                }
            }
        }
        return dp[S];
    }
}
