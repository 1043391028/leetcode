package leetcode_115_numOfDistinct;

//  题目: 不同的子序列;
//  描述: 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//
//        字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
//         （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//
//        题目数据保证答案符合 32 位带符号整数范围。
//
// 思路一: dp(动态规划)

public class Solution1 {
    public int numDistinct(String s, String t) {
        // 下面语句不用判断,该情况包含在 dp 数组中dp[0][0];
        // if(s.length() == 0 && t.length() == 0) return 1;
        int slen = s.length(), tlen = t.length();
        // 定义dp数组; dp[i][j] 表示到 s 中第 i 个字母和t中第 j 个字母时 s(0-i) 共有多少个目标字符串t(0-j);
        int[][] dp = new int[slen+1][tlen+1];
        // 都为空时初始化为 1; 其实状态转移方程决定了只要t数组为空时,即dp[i][0] =1;
        // 如 s = "bagbaag" t = "bag" i = 3(第二个b),j = 0(b);
        //    dp[4][1] = dp[3][0](1) + dp[3][1](1) = 2;
        //      如果dp[3][0] = 0 ; 就得不到正确答案;
        dp[0][0] = 1;
        for(int i = 1;i<slen;i++) dp[i][0] = 1;
        for(int j = 0;j<tlen;j++){
            for(int i = 0;i<slen;i++){
                if(s.charAt(i) == t.charAt(j)){
                    // 状态转移方程,当前字符相同,就是dp[i][j](同时减去当前字母) + dp[i][j+1](s减去当前字母,l 不动);
                    dp[i+1][j+1] = dp[i][j] +dp[i][j+1];
                }else{
                    // 不相等就是dp[i][j+1](有可能s当前字母(i) 之前的字符串存在和 l 相等的字符串)
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[slen][tlen];
    }
}
