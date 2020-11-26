package leetcode_139_wordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// 题目:给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//说明：
//      拆分时可以重复使用字典中的单词。
//      你可以假设字典中没有重复的单词。
//
// 思路: 动态规划dp
public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
//        判空
        if(s == null || wordDict == null) return true;
//        新建HAshSet保存wordDict里面的单词,后面检查
        HashSet<String> set = new HashSet<>();
//        maxLong为了后面剪枝,len为dp[]长度;
        int maxLong = 0 ,len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true; //初始化第一个字母之前为真;
//        把wordDict里面的单词保存到HashSet中;
        for(String word : wordDict){
            set.add(word);
            if(word.length() > maxLong){
                maxLong = word.length();
            }
        }
//       两个for循环,第一个是遍历s数组,直到最后一个字符,最后一个便是所求;
//      dp[i]表示第i个字母之前(包括i)能否构成wordDict里面单词;
        for(int i= 1;i <= s.length();i++){
            for(int j = i - maxLong < 0?0:i-maxLong;j < i;j++){ // 注意这里面的剪枝;直接从倒数'最长字母长度'单词开始遍历,
                            // 当从j开始到i剩余字母个数大于最长字母擦汗高难度时,那么就一定不包含在set中了;
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
