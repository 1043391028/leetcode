package leetcode_647_HuiWenSubArray;

//  思路2: dp动态规划法;
//

public class Solution2 {
    public int countSubstrings(String s){
        if(s == null || s.length()==0) return 0;
        int len = s.length(), count = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0;i<len;i++){
            for( int j = 0;j<=i;j++){
                // 下面条件仔细体会,当前两字母相等,要么二者挨着,要么dp[i+1][j-1] ==true;能使dp[i][j] == true;
                if(s.charAt(i) == s.charAt(j) && (i-j<2 ||dp[j+1][i-1])){
                    dp[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
