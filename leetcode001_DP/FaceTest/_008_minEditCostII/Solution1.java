package FaceTest._008_minEditCostII;

// 题目： 最小编辑代价II；
//        给定两个字符串str1和str2，再给定三个整数ic，dc和rc，
//        分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。

//  思路一: dp[][];

public class Solution1 {
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int len1 = str1.length(), len2 = str2.length();
        // 构建二维dp[][]数组： dp[i][j] 表示 str1中前i 个字母和 str2前 j 个字母匹配需要最少的次数；
        int[][] dp = new int[len1+1][len2+1];
        // 初始化第一行第一列；
        for(int i = 1;i<=len2;i++) dp[0][i] = dp[0][i-1]+ic; // str1 第0个字母变为str2 前 i 个字母需要的代价；
        for(int j = 1;j<=len1;j++) dp[j][0] = dp[j-1][0]+dc; // str1 第j个字母变为str2 前0 个字母需要的代价；
        for(int i =1;i<=len1;i++){
            // 遍历当前str1第i个字母（str1[i-1]） 和 str2 第j个字母是否匹配；
            for(int j =1;j<=len2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // 不匹配就找出删除/插入/替换中代价最小的；
                    int m = dp[i][j-1] + ic; // 插入 str1前i个字母变为str2前j-1个，然后再插入一个字母和str2第j个字母相等；
                    int n = dp[i-1][j] + dc; // 删除 str1前i-1个字母变为str2前j个，然后删除第i个；
                    int p = dp[i-1][j-1] + rc; // 替换 
                    dp[i][j] = Math.min(p,Math.min(m,n));
                }
            }
        }
        return dp[len1][len2];
    }
}
