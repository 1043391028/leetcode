package lc_1588_SumOfOddArray;

//  题目： 所有奇数长度子数组的和；
//  描述： 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
//
//         子数组 定义为原数组中的一个连续子序列。
//
//          请你返回 arr 中 所有奇数长度子数组的和 。

//   思路： 循环遍历数组，求出当前数 arr[i] 在奇数数组中的次数；
//           时间复杂度 o(n);
//

public class Solution1 {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length,res = 0;
        for(int i = 0;i < len; i++){
            //  计算当前位置 i 前面（left）,后面（right）分别有多少元素可以选择；
            int left = i + 1;
            int right = len - i;
            // 只有前面后面元素个数都选择偶数或者都选择奇数的情况能够满足奇数个元素条件；
            //  计算 当前元素位置 i 前面，后面选择奇数的个数；
            int leftodd = left/2, rightodd = right/2;
            //  计算 当前元素位置 i 前面，后面选择偶数数的个数；
            int leftEven = (left+1)/2, rightEven = (right+1)/2;
            // 统计该元素出现在奇数个数子数组总次数：leftodd*rightodd + lefteven*righteven;
            res += (leftodd*rightodd + leftEven*rightEven)*arr[i];
        }
        return res;
    }
}
