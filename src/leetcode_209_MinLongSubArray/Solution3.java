package leetcode_209_MinLongSubArray;
//
//   思路三： 二分法查找；
//            题目给出数组递增且为正，则新建一个数组sums[i] 表示前 i+1 个数的和；
//               sums数组一定是递增的，若sums[j] - s > sums[i] (i<j)，则nums[i] 到nums[j]之间的数组是满足条件的子数组，
//                  更新 min = Math.min(min,j-i);
//                    已知sums[i] 找满足条件的sums[j]可用二分法查找： sums[j] >= sums[i] +s;

import leetcode_018_sumOfFourNum.Solution;

public class Solution3 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] sums = new int[len+1];
        for(int i = 1;i <= len;i++){
            sums[i] = sums[i-1]+nums[i-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i =0;i <= len;i++){
            int target = s + sums[i];
            int j = binaryFind(sums,target);
            if(sums[j] < target) break; // 非常重要；如果sums[i] + s < sums[j] 说明二分查找到的下标 j 元素
                                             // 是sums数组最后一个元素，因为我们给的二分查找总会返回一个
                                             // 因为所有的都不符合，就返回的最后一个下标；
            min = Math.min(min,j-i);
        }
        return min == Integer.MAX_VALUE?0:min;
    }
    public int binaryFind(int[] nums,int target){
        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        Solution3 solution3 = new Solution3();
        int longth = solution3.minSubArrayLen(7,nums);
        System.out.println("最短子数组长度为：" + longth);
    }
}
