package lc_1647_minDeletion;

// 题目描述: 字符频次唯一的最小删除次数；

import java.util.HashSet;

//         如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
//
//         给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
//
//         字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
//
//示例 1：
//        输入：s = "aab"
//        输出：0
//        解释：s 已经是优质字符串。
//示例 2：
//
//        输入：s = "aaabbbcc"
//        输出：2
//        解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
//        另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc"
//
//     核心思路：  统计字符串 s 中字母的次数，放在HashSet中
//
public class Solution1 {
    public int minDeletions(String s) {
        int res = 0, len = s.length();
        // nums数组存放各个字母的个数；
        int[] nums = new int[26];
        char[] ns = s.toCharArray();
        for(char ch : ns){
            nums[ch-'a']++;
        }
        // hashset 存字母个数（只存不一样的个数，在存之前，先判断是否存在一样的次数，
        //   一旦存在一样的次数，就先个数 --，然后结果统计次数 res++）
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            if(i > 0){
                while(set.contains(i)){
                    res++;
                    i--;
                }
                if(i != 0) set.add(i); // 某个字母的次数减到 0 ，说明该字母已经完全删去；
            }
        }
        return res;
    }
}
