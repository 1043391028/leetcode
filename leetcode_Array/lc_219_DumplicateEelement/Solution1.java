package lc_219_DumplicateEelement;

//  题目： 存在重复元素II;
//  描述: 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
//          使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
//
//  思路一：暴力遍历；
//            时间复杂度：o(n^2);效率低；

public class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j < nums.length && j<i+k+1;j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}


