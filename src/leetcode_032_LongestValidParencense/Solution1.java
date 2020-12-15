package leetcode_032_LongestValidParencense;

//  题目： 最长有效括号；
//  描述： 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//示例 1:
//         输入: "(()"
//         输出: 2
//  解释: 最长有效括号子串为 "()"

//  思路一： dp动态规划；
//          dp[i] 表示第 i 个字母前的最长有效括号串；

public class Solution1 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length(), maxLen = 0;
        // 初始化dp数组，长度为 len+1 方便表示第个字符前最长有效长度；
        int[] dp = new int[len + 1];
        //  i == 2 开始，因为第一个字母有效字符串肯定为 0；
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) == ')') {
                //  当前字符‘）’ 上一个字符'('
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] - 1 > 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                    dp[i] = ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
    public static void main(String[] str){
        Solution1 solution1 = new Solution1();
        String s = "(()())";
        int longth = solution1.longestValidParentheses(s);
        System.out.println(longth);
    }
}

