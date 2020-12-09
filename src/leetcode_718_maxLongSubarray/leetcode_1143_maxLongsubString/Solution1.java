package leetcode_718_maxLongSubarray.leetcode_1143_maxLongsubString;

//  题目: 最长公共子序列;
//  描述: 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
//
//       一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
//        （也可以不删除任何字符）后组成的新字符串。
//         例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//          两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//             若这两个字符串没有公共子序列，则返回 0。
//
//示例 1:
//          输入：text1 = "abcde", text2 = "ace"
//          输出：3
//   解释：最长公共子序列是 "ace"，它的长度为 3。

///  思路: 动态规划,下面是优化过的版本(在二维动态数组基础上);二维动态数组规划放在后面;

public class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length()==0)
            return 0;
        int max = 0, len1 = text1.length(), len2 = text2.length();
        // 定义动态数组长度为第二个数长度Len2 +1;
        //  外层遍历len1次,实际上就是动态求第 i(1,2,3...len1)行,第 j 个元素前对应的最长子序列;
        //   只是我们只需要保存前一行就可以求下一行;因为动态方程dp[i][j] == Math.max(dp[i-1][j],dp[i][j-1])
        int[] dp = new int[len2+1];
        // int last = 0; last(保存左上角元素)不能再这里,应该放在第一层和第二层循环之间;
        for(int i=1; i<= len1;i++){
            int last = 0;
            // 上一个求最长子串(连续)的简化版,内层循环必须从后面,但是这里求最长子序列必须从前往后;
            // 因为dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])=>dp[j] = Math.max(dp[j],dp[j-1])
            //   其中 dp[j-1] 是依赖前面更新过的(也就是当前行的),如果从后往前,dp[j-1]保存的还是上一行的(也就是last);
            for(int j = 1;j<= len2;j++){
                int temp = dp[j];
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[j] = last +1;
                }else{
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
                max = Math.max(dp[j],max);
                last = temp;
            }
        }
        return max;
    }
}

//   public int longestCommonSubsequence0(String text1, String text2) {

//    	// dp[i][j]代表text1前i（下标）个元素和text2前j个元素的最长公共子序列长度

//    	int len1 = text1.length();
//    	int len2 = text2.length();
//    	int[][] dp = new int[len1 + 1][len2 + 1];
//    	for(int i = 0; i < len1; i++) {
//    		for(int j = 0; j < len2; j++) {
//    			if(text1.charAt(i) == text2.charAt(j)) { // 如果相等
//    				dp[i + 1][j + 1] = dp[i][j] + 1;
//    			}else { // 如果不相等
//    				dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
//    			}
//    		}
//    	}
//    	return dp[len1][len2];
//    }
