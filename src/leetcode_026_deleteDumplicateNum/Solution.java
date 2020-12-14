package leetcode_026_deleteDumplicateNum;

//  题目 ： 删除数组中的重复项；
//
// 思路 ：   双指针；
//           首先注意数组是有序的，那么重复的元素一定会相邻。
//
//           要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        int i = 0;
        for(int j =1;j< nums.length;j++){
            if(nums[j] != nums[i]){
                // 这路优化一下，只有不相邻的时候才进行传引用（将不同的元素移到左边并且相邻）；
                if(j-i>1){
                    nums[++i] = nums[j];
                } else i++;
            }
        }
        return i+1;
    }
}
