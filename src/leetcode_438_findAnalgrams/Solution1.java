package leetcode_438_findAnalgrams;

import java.util.ArrayList;
import java.util.List;

//   题目: 找到字符串中所有的字母异位词;
//   描述: 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
//         字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//   说明：
//         字母异位词指字母相同，但排列不同的字符串。
//          不考虑答案输出的顺序。
//
//   思路: 滑动窗口;
public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        // 新建保存结果链表
        List<Integer> res = new ArrayList<>();
        // 新建数组,保存字符串s,p;
        char[] arrayS = s.toCharArray();
        char[] arrayP = p.toCharArray();
        // 新建窗口和目标字符串数组(保存滑动窗口中和目标串中各字母的个数)
        int[] needs = new int[26];
        int[] windows = new int[26];
        // 遍历目标字符串,保存字符串中各字母的个数;
        for(char ch:arrayP){
            needs[ch-'a'] += 1;
        }
        // 串口左右边界;
        int left = 0;
        int right = 0;
        // 窗口欢动过程;
        while(right < arrayS.length){
            // 保存当前窗口右边界right字母对应的整数;
            int curR =  arrayS[right]-'a';
            right++; // 窗口右边界右移;
            windows[curR]++;// 窗口中该字母所在数组位置 个数+1;
            // 当窗口中某字母的个数大于目标窗口中的该字母个数,需要右移左边界压缩窗口;直至窗口中该字母个数不大于目标窗口;
            // 如 窗口windows中 abcd ,目标字符串abc,则窗口左边界left需要右移直到指向字母d位置;
            while(windows[curR] > needs[curR]){
                int curL = arrayS[left]-'a';
                left++;
                windows[curL]--;
            }
            // 判断,如果窗口大小等于目标字符串个数,左边界加入结果链表;
            if(right - left == arrayP.length){
                res.add(left);
            }
        }
        return res;
    }
}
