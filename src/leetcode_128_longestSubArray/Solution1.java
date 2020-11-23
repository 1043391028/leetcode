package leetcode_128_longestSubArray;

//  题目：给定一个未排序的整数数组 nums ，找出数字连续的最长序列
//        （不要求序列元素在原数组中连续）的长度。
//
//        进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
//  思路：利用 HashSet 保存数组中所有的元素，并且遍历 hashSet ,
//        遍历的时候利用set.contains()函数判断是否存在 当前值+1 的元素；
//        存在就用一个 while() 循环遍历有多少连续+1的值，更新当前最长连续序列；
//         在遍历前检查是否存在 当前值-1 的值，存在就跳过；这样节省了遍历；

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int longest = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentLong = 1;
                while(set.contains(currentNum+1)){
                    currentNum += 1;
                    currentLong += 1;
                }
                longest = Math.max(longest,currentLong);
            }
        }
        return longest;
    }
}
