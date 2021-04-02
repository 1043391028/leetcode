package FaceTest._004_LongestsubArr;

//  题目： 最长公共子串；
//  描述： 给定两个字符串str1和str2,输出两个字符串的最长公共子串
//         题目保证str1和str2的最长公共子串存在且唯一。
//  思路一：
//         DP;
//    思路二：
//            库函数： str1.contains();

public class Solution1 {
        /**
         * longest common substring
         * @param str1 string字符串 the string
         * @param str2 string字符串 the string
         * @return string字符串
         */
        public String LCS (String str1, String str2) {
            // write code here
            int len1 = str1.length(), len2 = str2.length();
            //   新建dp数组，dp[l][r] : str1 第 1~l 个字符 和 str2 第 1 ~ r 个字符的最长公共子串；
            int[][] dp = new int[len1+1][len2+1];
            //  初始化 dp[0][0] = 0 , 为了便于构建转移方程，直接从  l=1 ,r=1 开始；
            //       因为状态转移方程为 dp[l][r] = dp[l-1][r-1] ;
            dp[0][0] = 0;
            int maxlen = 0, end = 0;
            for(int r = 1;r<=len1;r++){
                for(int l =1; l<=len2;l++){
                    int curmax = 0;
                    if(str1.charAt(r-1) == str2.charAt(l-1)){
                        dp[r][l] = dp[r-1][l-1] +1;
                        curmax = Math.max(maxlen,dp[r][l]);
                        if(curmax != maxlen){
                            maxlen = curmax;
                            end = r; // 注意： 这里的end代表的字符下标是：str1[end-1];
                                    //         如果代表的是str[end],最后截取的结果要 end+1 ,
                                    //          即str1.substring(end-maxlen+1, end+1);
                        }
                    }
                }
            }
            return str1.substring(end-maxlen,end);
        }
}
