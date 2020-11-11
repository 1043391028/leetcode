package leetcode_53_maxSubArray;

//     题目: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

//      思路： 遍历数组，用一个数 curSum 表示遍历到当前值的和，Sum 表示至今保存更新的最大值；
//             只有当CurSum值为正的时候才和下一个值相加，否则更新 curSum 为当前遍历值；继续往后遍历；更新；

public class Solution1 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int sum = nums[0], curSum = 0;

        for(int i = 0 ; i < nums.length; i++){
            if(curSum >= 0){
                curSum = curSum + nums[i];
            }else curSum = nums[i];

            sum = Math.max(sum,curSum);  // 不断保存遍历过程中最大子序列和的值；
        }
        return sum;
    }
}
