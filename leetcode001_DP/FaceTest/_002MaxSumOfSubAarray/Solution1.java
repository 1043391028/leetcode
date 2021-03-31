package FaceTest._002MaxSumOfSubAarray;

// 题目:   给定一个数组arr，返回子数组的最大累加和
//      例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
//     题目保证没有全为负数的数据
//[要求]
//      时间复杂度为O(n)，空间复杂度为O(1)
//  思路一：
//         遍历数组，统计到当前位置的最大和curSum，如果小于 0 则更新为0（相当于之前的舍弃，从下个位置找最大和）
//           在此过程不断更新最大和 MaxSum;
//  思路二： dp(动态规划)
//            实际上和思路一是一样的；dp[i] 表示当前的最大和；
//              状态转移方程： dp[i] = dp[i-1] + arr[i]( dp[i-1] > 0);

public class Solution1 {
        /**
         * max sum of the subarray
         * @param arr int整型一维数组 the array
         * @return int整型
         */
        public int maxsumofSubarray (int[] arr) {
            // write code here
            int maxSum = 0, len = arr.length;
            int curSum = 0; // curSum 保存从某个位置Ⅶ到当前位置的和 ；
            for(int i =0;i<len;i++){
                curSum += arr[i];
                //  保证 curSum >0  这样能保证 往后面 + 才是可以使结果MaxSum变大的；
                if(curSum < 0){
                    curSum = 0;
                }
                // 更新 MaxSUm;
                maxSum = Math.max(maxSum,curSum);
            }
            return maxSum;
        }
}
