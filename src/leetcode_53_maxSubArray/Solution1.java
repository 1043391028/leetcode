package leetcode_53_maxSubArray;

//     题目: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

//

public class Solution1 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int sum = nums[0], curSum = 0;

        for(int i = 0 ; i < nums.length; i++){
            if(curSum >= 0){
                curSum = curSum + nums[i];
            }else curSum = nums[i];

            sum = Math.max(sum,curSum);
        }
        return sum;
    }
}
