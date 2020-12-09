package leetcode_718_maxLongSubarray;

//   题目: 最长重复子数组;
//   描述: 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//   示例：
//         输入：
//              A: [1,2,3,2,1]
//              B: [3,2,1,4,7]
//         输出：3
//   解释：
//         长度最长的公共子数组是 [3, 2, 1] 。

//   思路: dp;(这里代码是内存优化版的)

public class Solution1 {
    public int findLength(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0|| B.length == 0)
            return 0;
        int lenA = A.length, lenB = B.length;
        //  定义动态数组为一维,只保留上一行结果;
        // 长度为 lenB(B数组长度)+1 dp[0]=0(默认),遍历lenA(A数组长度)次,每次相当于在更新dp[i][j];
        int[] dp = new int[lenB+1];
        int max = 0;
        for(int i =1;i<=lenA;i++){
            // 这里内层循环需要注意,要从后往前遍历,因为后面的结果依赖前面的(如,dp[4] = dp[3]+1)
            //   如果前面更新,会影响后面的结果;
            for(int j = B.length;j>=1;j--){
                if(A[i-1] == B[j-1]){
                    dp[j] = dp[j-1] +1;
                }else{
                    dp[j] = 0;
                }
                max = Math.max(max,dp[j]);
            }
        }
        return max;
    }
}
