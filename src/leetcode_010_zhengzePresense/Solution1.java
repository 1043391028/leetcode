package leetcode_010_zhengzePresense;

//  题目: 正则表达式匹配;
//  描述:  给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//         '.' 匹配任意单个字符
//          '*' 匹配零个或多个前面的那一个元素
//         所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

//  思路: dp;
//       目标字母: s, 匹配字母: p;
//

public class Solution1 {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null) return true;
        // 下面语句防止 s = "" p = "c*" 的情况;
        s = " " + s;
        p = " " + p;
        char[] sArray = s.toCharArray(), pArray = p.toCharArray();
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int i = 1;i < sLen;i++){
            for(int j = 1;j < pLen;j++){
                if(sArray[i-1] == pArray[j-1] || pArray[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pArray[j-1] == '*'){
                    if(pArray[j-2] != sArray[i-1] && pArray[j-2] != '.'){
                        dp[i][j] = dp[i][j-2];
                    }else{
                        dp[i][j] = dp[i][j-1]|| dp[i-1][j] || dp[i][j-2];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

}
