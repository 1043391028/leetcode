package leetcode_209_MinLongSubArray;

//  思路二： 双指针；
//  大致思路： start头指针，end尾指针从 0 开始遍历数组，sum 为数组start 到 end之间元素和；
//               当 sum >= s 时，记录end - start 的个数，更新最小子数组个数 min；
//                  同时 头指针往前移动，压缩窗口，期间更新sum 的值，如果期间 sum >= s 依然成立，依然更新 min 值；

public class Solution2 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int start = 0,end = 0,sum = 0,min = Integer.MAX_VALUE;
        while(end < len){
            sum +=nums[end++];
            while(sum >= s){
                min = Math.min(min,end - start);
                sum -=nums[start++];
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}
