package leetcode_72_minDistanseOfConvertWord;

//    题目： 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//           你可以对一个单词进行如下三种操作：
//
//                 插入一个字符
//                 删除一个字符
//                 替换一个字符

//     思路：动态规划（Dfs）

public class Solution1 {
    public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
//            初始化；这里以 word1 word2 第一个字母为空；
            int[][] dp = new int[m+1][n+1];
//            第一行，这里设置 word1 第一个字母为空
            for(int i = 1;i <= n;i++) dp[0][i] = dp[0][i-1] +1;
//            第一列；同样设置 word2 第一个字母为空；
            for(int i = 1; i <= m;i++) dp[i][0] = dp[i-1][0] + 1;

            for(int i = 1; i < m+1; i++){
                for(int j = 1; j < n+1;j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                    }
                }
            }
            return dp[m][n];
    }
}
