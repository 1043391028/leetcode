package leetcode002_DFS.lc_0131_PartationString;

// 题目： 分割回文串
//      给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
//      回文串 是正着读和反着读都一样的字符串。
//示例 1：
//        输入：s = "aab"
//        输出：[["a","a","b"],["aa","b"]]
//
//  思路： DP + DFS

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        // 构建dp数组，判断从 i ~ j 位之间的字符串是否是回文串；
        boolean[][] dp = new boolean[len][len];
        for(int i = 0;i<s.length();i++){
            for(int j = 0;j<=i;j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1]))
                    dp[j][i] = true;
            }
        }
        DFS(s,0,res,new ArrayList<>(),dp);
        return res;
    }
    //  深度递归 + 回溯；
    public void DFS(String s,int index,List<List<String>> res,ArrayList<String> temp,boolean[][] dp){
        // 递归出口： 遍历到最后一位，中间均满足条件，将中间遍历的过程 缓存串 temp 加入到结果；
        if(index == s.length()){
            // 注意要 new 一个,不能直接用 temp;
            //  深拷贝；如果直接用 temp 加入的是地址，最后肯定为空，因为回溯会把 temp 中的缓存字符串删掉；
            res.add(new ArrayList<>(temp));
            return ;
        }
        for(int i = index;i < s.length();i++){
            if(dp[index][i]){
                temp.add(s.substring(index,i+1));
                DFS(s,i+1,res,temp,dp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
