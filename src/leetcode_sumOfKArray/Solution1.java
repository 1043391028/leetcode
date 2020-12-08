package leetcode_sumOfKArray;

//  题目: 和为k的连续子数组;
//  描述: 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
//示例 1 :
//        输入:nums = [1,1,1], k = 2
//        输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 说明 :
//        数组的长度为 [1, 20,000]。
//        数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
//
// 思路一: 暴力解法;嵌套循环遍历;
public class Solution1 {
    public int subarraySum(int[] nums, int k) {
        if(nums == null|| nums.length == 0) return 0;
        int count = 0;
        for(int i =0;i<nums.length;i++){
            int curSum =0;
            for(int j =i;j<nums.length;j++){
                curSum +=nums[j];
                if(curSum == k) count++;
            }
        }
        return count;
    }
}
