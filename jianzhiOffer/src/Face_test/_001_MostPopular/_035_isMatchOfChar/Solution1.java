package src.Face_test._001_MostPopular._035_isMatchOfChar;

//  题目: 通配符匹配；
//  描述： 请实现支持'?'and'*'.的通配符模式匹配
//             '?' 可以匹配任何单个字符。
//             '*' 可以匹配任何字符序列（包括空序列）。
//       返回两个字符串是否匹配
//函数声明为：
//          bool isMatch(const char *s, const char *p)
//          下面给出一些样例：

//  思路一：
//          dp;

public class Solution1 {
    public boolean isMatch(String s, String p) {
        if((s == null && p == null) || (s.length() == 0 && p.length() == 0))
            return true;
        if(p.length() == 0 && s.length() != 0)
            return false;
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;
        //  初始化第一行；
        //  针对s为空， p中 * 字母情况；
        for(int i = 0;i<plen;i++){
            if(p.charAt(i) == '*') dp[0][i+1] = dp[0][i];
        }
        for(int i = 0;i<slen;i++){
            for(int j = 0;j<plen;j++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
                }
            }
        }
        return dp[slen][plen];
    }
}
