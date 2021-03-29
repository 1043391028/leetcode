package leetcode001_DP.lc_0357_countNumWithUniqueDigitals;

// 题目： 计算各位数不同的数；
//       给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
//
//示例:
//      输入: 2
//      输出: 91
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
//
//  思路： dp;
//
public class Solution1 {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n+1];
        //  下面的判断语句必须有，要不然n = 0 时，dp[1] 越界；
        if(n == 0) return 1;
        //  初始化；
        dp[0] = 1;
        dp[1] = 10;
        for(int i =2;i<=n;i++){
            //  dp[i-1] 小于一位位数的个数；dp[i-1] - dp[i-2] 表示只有 i-1 位数字的不重复数字个数；
            //            10 - i +1 ： 表示还有多少个数字没用；
            //   如： i = 4； 下面语句就是说： 3位数字（包括两位和一位）的不重复数个数 + 仅有3位数基础上增加一位的个数；
            dp[i] = dp[i-1] + (dp[i-1]-dp[i-2])*(10-i+1);
        }
        return dp[n];
    }
}
