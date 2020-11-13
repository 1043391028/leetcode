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
//           下面遍历两个单词构成的 “二维数组” 直接从dp[1][1]开始，因为第一行、第一列都已初始化；
//            接下来可直接使用 DFS 来求下面每一个动态规划点；
//        dp[i][j] 代表 word1 第 i 个单词和 word2 第 j 个单词匹配情况
            for(int i = 1; i < m+1; i++){
                for(int j = 1; j < n+1;j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
//                        如果当前比较的的单词相等可以直接得到dp[i][j] = dp[i-1][j-1];
//                   也就是当前单词匹配，整个单词匹配情况由二者上一个确定；
                        dp[i][j] = dp[i-1][j-1];
                    }else {
//                  (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
//
//                  (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
//
//                  (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符

                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                    }
                }
            }
            return dp[m][n];
    }
}
