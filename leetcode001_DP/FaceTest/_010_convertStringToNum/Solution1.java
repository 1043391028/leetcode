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
        // 定义dp数组，dp[i] 表示第i+1个字母为转化的可能情况；
        int[] dp = new int[len];
        if(s[0] == '0') return 0;
        // 初始化，只有一个字母：一种情况（0已经在上一步排除）；
        dp[0] = 1;
        for(int i = 1;i<len;i++){
            // 如果当前字母不为‘0’ ，首先将该字母作为一个数字的情况保存到dp[i];
            if(s[i] != '0') dp[i] = dp[i-1];
            // 计算后两位字母代表二位数 num；
            int num = (s[i-1]-'0')*10 + (s[i]-'0');
            // 如果 num满足 10<= num <=26 则后两个字母可以组成两位数（为一种情况：dp[i-2]）;
            if(num>=10 && num <= 26){
                // 实际上 dp[i] == dp[i-1] + dp[i-2]只不过第一步dp[i]初始化为了dp[i-1];
                dp[i] += i>1?dp[i-2]:1;
            }
        }
        return dp[len-1];
    }
}
