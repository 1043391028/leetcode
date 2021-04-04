package FaceTest._007_MaxSumOFNotAdjustNumArr;

//  题目： 不相邻最大子序列和；
//   描述:    给你一个n（1\leq n\leq10^51≤n≤105），
//       和一个长度为n的数组，在不同时选位置相邻的两个数的基础上，求该序列的最大子序列和（挑选出的子序列可以为空）。

//  思路一：
//            实际上就是打家劫舍问题；
//            dp[i] 表示选择当前数；
//            dp[i] = Math.max(dp[i-1](不选择当前数),dp[i-2] + arr[i-1](选择当前数，不选前面相邻的数))
//
public class Solution1 {

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 计算
         * @param n int整型 数组的长度
         * @param array int整型一维数组 长度为n的数组
         * @return long长整型
         */
        public long subsequence (int n, int[] array) {
            // write code here
            int[] dp = new int[n+1];
            dp[1] = array[0];
            for(int i = 2;i<=n;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+array[i-1]);
            }
            return dp[n];
        }
}
