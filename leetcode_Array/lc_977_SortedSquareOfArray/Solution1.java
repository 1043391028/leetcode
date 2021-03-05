package lc_977_SortedSquareOfArray;

// 题目： 有序数组的平方；
// 描述： 给你一个按 非递减顺序 排序的整数数组 nums，
//       返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

//    思路一： 双指针；

public class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int i =0, j = nums.length-1, len = j;
        int[] res = new int[len+1];
        while(i <= j){
            int m = nums[i]*nums[i];
            int n = nums[j]*nums[j];
            if(m >= n){
                res[len--] = m;
                i++;
            }else{
                res[len--] = n;
                j--;
            }
        }
        return res;
    }
}
