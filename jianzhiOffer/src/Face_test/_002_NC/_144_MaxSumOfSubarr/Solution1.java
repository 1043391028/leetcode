package src.Face_test._002_NC._144_MaxSumOfSubarr;

//  题目： 子序列最大和；

//  描述： 给你一个n（1≤n≤105），和一个长度为n的数组，
//         在不同时选位置相邻的两个数的基础上，求该序列的最大子序列和（挑选出的子序列可以为空）。
//示例1
//      输入：
//           3,[1,2,3]
//    返回值：
//            4
//    说明：
//         有[],[1],[2],[3],[1,3] 4种选取方式其中[1,3]选取最优，答案为4

//    思路一: 大意就是不能找相邻的元素,找出和最大的子序列;
//            DP;  类似于偷房间的思路;

public class Solution1 {
    public long subsequence (int n, int[] array) {
        int len = array.length;
//         二维数组,dp[i][0]: 第i+1 个数不选择,dp[i][1] 选择第i+1个数;
        int dp[][] = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = array[0];
        long max =  Math.max(dp[0][0],dp[0][1]);
        for(int i = 1;i<len;i++){
            //  转换方程: 不选择当前数字,可以选择上个数字:1.不选择dp[i-1][0],2.选择dp[i-1][1];
            //            选择当前数字, 上个数字只能是不选择(不能选择相邻的数字)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + array[i];
            max = Math.max(Math.max(dp[i][0],dp[i][1]),max);
        }
        return max;
    }
}
