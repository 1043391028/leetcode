package leetcode_091_numOfDecode;

//   题目: 解码方法;
//   描述: 一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//          'A' -> 1
//          'B' -> 2
//          ...
//          'Z' -> 26
//        给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
//         题目数据保证答案肯定是一个 32 位的整数。
//  思路: dp
//

public class Solution1 {
    public int numDecodings(String s) {
        // 初始判断;
        if(s.length() ==0) return 0;
        // 这一步很重要,不能少,因为s == '0' 在动态数组初始化dp[1]情况为1, 实际上应该返回0;
        if(s.charAt(0) == '0') return 0;
        char[] str = s.toCharArray();
        // 定义动态数组,dp[i] 表示前 i+1 个字母前(包括s[i])有多少种解码方式;
        int[] dp = new int[s.length()+1];
        // 初始化dp[0] ==1 是本身代表没有字母的组合,应该为0,
        //  但是,因为下面转移方程中有转移到 dp[0](代表一种组合)的情况,所以不能初始化为 0;
        dp[0] = 1;
        dp[1] = 1;
        for(int i=1;i < s.length();i++){
            if(str[i] == '0'){
                if(str[i-1]-'0' == 1 || str[i-1]-'0' ==2) dp[i+1] = dp[i-1];
                else dp[i+1] = 0;
            }else{
                if(str[i-1]-'0'==1 || (str[i-1]-'0' == 2 && str[i]-'0'>0 && str[i]-'0'<7))
                    dp[i+1] = dp[i] + dp[i-1];
                else dp[i+1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}
