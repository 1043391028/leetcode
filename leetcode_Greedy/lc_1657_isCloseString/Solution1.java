package lc_1657_isCloseString;

// 题目： 确定两个字符是否接近；
//  描述： 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
//
//        操作 1：交换任意两个 现有 字符。
//                例如，abcde -> aecdb
//        操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
//                例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
//        你可以根据需要对任意一个字符串多次使用这两种操作。
//
//      给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false
//
//  核心思路： 1. 两个字符串中的字母种类要一样；
//            2. 每一个字母种类需要在另一个字母中有对应个数的字母；

import java.util.Arrays;

public class Solution1 {
    public boolean closeStrings(String word1, String word2) {
        int[] str1 = new int[26], str2 = new int[26];
        //  长度不一样，直接返回false;
        if(word1.length() != word2.length()) return false;
        // 统计字母个数；
        for(char ch : word1.toCharArray()){
            str1[ch-'a']++;
        }
        for(char ch: word2.toCharArray()){
            str2[ch-'a']++;
        }
        // 遍历 26 个字母，字母不能只在一个字符串中存在；
        for(int i=0;i<26;i++){
            if((str1[i] == 0 && str2[i]!=0) || str1[i] !=0 && str2[i]==0)
                return false;
        }
        // 排序，判断个数是否相等；
        Arrays.sort(str1);
        Arrays.sort(str2);
        for(int i = 0;i<26;i++){
            if(str2[i] != str1[i])
                return false;
        }
        return true;
    }
}
