package leetcode_35_search_insert;

//  思路二： 简单遍历；

public class Solution1 {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        for(int i=0 ;i < nums.length;i++){
            if(nums[i]>= target){
                return i;
            }
        }
        return nums.length;
    }
}
