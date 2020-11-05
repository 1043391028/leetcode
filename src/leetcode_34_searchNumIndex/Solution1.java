package leetcode_34_searchNumIndex;

//     题目描述：在排序数组中查找元素的第一个和最后一个位置
//               给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//               你的算法时间复杂度必须是 O(log n) 级别。
//
//                如果数组中不存在目标值，返回 [-1, -1]。


public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums == null || nums.length == 0) return result;

        int left = 0, right = nums.length -1 , mid = 0;

        while(left < right){
            mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid +1;
            } else right = mid;
        }
        if(nums[left] != target) return result;
        result[0] = left;
        right = nums.length - 1;
        while(left < right){
            mid = left + (right -left)/2;
            if(nums[mid] > target) right = mid;
            else left = mid +1;
        }
        result[1] = left-1;
        return result;
    }
}
