package leetcode_05_longestHuiWenString;

//    思路二：  动态规划；
//            大致思路：  Boolean dp[i][j] 表示array[i] 和 array[j] 字符之间的字符是否满足会问序列；
//

public class solution2 {
    public String longestPalindrome(String s){
        if(s.length() < 2) return s;
        int len = s.length();

        int maxsublen = 1;
        int start = 0;

        char [] array = s.toCharArray();
        boolean[][] dp =  new boolean [len][len];

        for(int j =1 ; j < len ; j++){
            for(int i = 0;i < j ; i++){

                if(array[i] != array[j]){
                    dp[i][j] = false;
                } else {
                    if(j-i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }

                if(j - i + 1 > maxsublen && dp[i][j]){
                    maxsublen = j - i +1 ;
                    start = i ;
                }
            }
        }
        return s.substring(start, start+maxsublen);
    }
}
