package leetcode_01_SumOfTwoNum;


//      题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//            你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。


import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            if(map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]),i};
            else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

}
