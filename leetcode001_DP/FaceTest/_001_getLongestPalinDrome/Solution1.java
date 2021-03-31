package FaceTest._001_getLongestPalinDrome;

//  题目： 最长回文子串；

//  描述： 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
//
//        给定字符串A以及它的长度n，请返回最长回文子串的长度。
// 思路一：
//         Dp(动态规划);

public class Solution1 {
        public int getLongestPalindrome(String A, int n) {
            // write code here
            if (n < 2) return n;
            int res = 1;
            boolean[][] dp = new boolean[n][n];
            for (int r = 0; r < n; r++) {
                for (int l = 0; l <= r; l++) {
                    // 转移方程；
                    if (A.charAt(l) == A.charAt(r) && (r - l < 3 || dp[l + 1][r - 1])) {
                        dp[l][r] = true;
                        res = Math.max(res, r - l + 1);
                    }
                }
            }
            return res;
        }
}
