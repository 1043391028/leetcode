package lc_MaxTurbulenceSubarr;

//  题目： 最长串流子数组；
//  描述： 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
//
//         若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
//        或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
//         也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
//
//        返回 A 的最大湍流子数组的长度。
//示例 1：
//         输入：[9,4,2,10,7,8,8,1,9]
//         输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])

// 思路一：  dp;
//          维护两个数组 up[i] 和 down[i] 表示 i 位置上升和下降的最大波浪数组长度；
//             up[i] 只能由 down[i-1] 转换；
//             down[i] 只能由 up[i-1] 转换；

import java.util.Arrays;

public class Solution1 {
       public int maxTurbulenceSize(int[] arr){
           int len = arr.length;
           int[] up = new int[len], down = new int[len];
           Arrays.fill(up,1);
           Arrays.fill(down,1);
           int res = 1;
           for(int i =1;i<len;i++){
               if(arr[i] > arr[i-1]){
                   up[i] = down[i-1] +1;
                   res = Math.max(up[i],res);
               }else if(arr[i] < arr[i-1]){
                   down[i] = up[i-1] +1;
                   res = Math.max(down[i],res);
               }
           }
           return res;
       }
}
