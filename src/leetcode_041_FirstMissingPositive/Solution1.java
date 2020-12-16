package leetcode_041_FirstMissingPositive;

//  题目： 第一个缺失的正数；
//  描述： 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//         示例 2:
//                 输入: [3,4,-1,1]
//                  输出: 2
//  提示：
//         你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
//
//  思路一： hashSet法（空间复杂度不符合条件）；

import java.util.HashSet;

public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i = 1;i <= nums.length;i++){
            if(!set.contains(i)) return i;
        }
        return nums.length+1;
    }
}
