package leetcode_016_sumOfThreeNum;

import java.util.Arrays;

//  题目: 最接近和的三个数;
//  描述:  给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
//           使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//  示例：
//        输入：nums = [-1,2,1,-4], target = 1
//        输出：2
//  解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

//  思路: 循环遍历数组, 遍历方式如下:
//         固定 i(当前遍历的数) 另外选择两个数 start = i+1, end = nums.length-1;
//          sum = nums[i] + nums[start] + nums[end];

public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        // ans 保存结果;初始化为前三个数和(任意三个数都行);不能初始化为0或者其他数;
        int ans = nums[0] + nums[1] +nums[2];
        Arrays.sort(nums);
        for(int i = 0;i < len-2 ;i++){
            int start = i+1, end = len-1;
            while(start < end){
                int sum = nums[i] + nums[start] +nums[end];
                if(Math.abs(target - sum) < Math.abs(target-ans)){
                    ans = sum;
                }
                if(sum > target){
                    end--;
                }else if(sum < target){
                    start++;
                }else{
                    return sum;
                }
            }
        }
        return ans;
    }
}
