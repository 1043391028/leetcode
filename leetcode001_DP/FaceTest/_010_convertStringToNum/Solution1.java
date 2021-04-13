package FaceTest._010_convertStringToNum;

// 题目： 把数字翻译成字符串的个数；
//  描述 : 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
//
//         现在给一串数字，返回有多少种可能的译码结果
//   思路一：
//            dp;

public class Solution1 {
    public int solve (String nums) {
        // write code here
        if(nums == null || nums.length() == 0) return 0;
        int len = nums.length();
        char[] s = nums.toCharArray();
        int[] dp = new int[len];
        if(s[0] == '0') return 0;
        dp[0] = 1;
        for(int i = 1;i<len;i++){
            // 
            if(s[i] != '0') dp[i] = dp[i-1];
            int num = (s[i-1]-'0')*10 + (s[i]-'0');
            if(num>=10 && num <= 26){
                dp[i] += i>1?dp[i-2]:1;
            }
        }
        return dp[len-1];
    }
}
