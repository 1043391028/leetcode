package FaceTest._008_longestKuoHao;

//  题目： 最长有效括号；
//  描述: 给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
//          对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
//        再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.

//  思路一：
//         dp;
// 思路二： 栈；
//   思路三： 不用额外空间（很巧妙）：
//            分别从字符串首尾分别各遍历一遍统计'（'和'）' 个数；

public class Solution1 {
    public int longestValidParentheses (String s) {
        // write code here
        if(s == null || s.length() < 2) return 0;
        int len = s.length();
        int[] dp = new int[len];
        int res = 0;
        for(int i = 1;i<len;i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = 2 + (i>=2?dp[i-2]:0);
                }else if(i>dp[i-1] && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1]+ (i-dp[i-1]>1?dp[i-dp[i-1]-2]:0)+2;
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        String s2 = "(()", s3 = "())";
        int len = s1.longestValidParentheses(s3);
        System.out.println(len);
    }
}
