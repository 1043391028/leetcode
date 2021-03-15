package lc_1497_canArrange;

// 题目： 检查数组是否可以被k整除；
//  描述： 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
//
//           现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
//
//         如果存在这样的分法，请返回 True ；否则，返回 False 。
//
//示例 1：
//       输入：arr = [1,2,3,4,5,10,6,7,8,9], k = 5
//       输出：true
// 解释：划分后的数字对为 (1,9),(2,8),(3,7),(4,6) 以及 (5,10) 。
//
//  思路： 、
//         遍历数组，统计余数对（和为k）的两个数个数是否相等；

public class Solution1 {
    public boolean canArrange(int[] arr, int k) {
        int[] array = new int[k+1];
        for(int i = 0;i<arr.length;i++){
            array[(arr[i]%k+k)%k]++;
        }
        for(int i=1;i<=k/2;i++){
            if(array[i] != array[k-i]) return false;
        }
        // 最后注意： 需要统计那些余数为 0 的个数，是否是2的倍数；
        return array[0]%2 == 0;
    }
}
