package leetcode_03_lengthOfLongestSubstring;

//      题目： 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//      解法1： 双指针做法；(hashmap思想)
//             建立一个数组，保存字符串中所有可能字符情况个数；


public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int[] num = new int[128];
        int len = s.length();
        int max = 0;
        for(int i = 0,j = 0 ; j < len ; j++){
            num[s.charAt(j)]++;
            while(num[s.charAt(j)] > 1){
                num[s.charAt(i++)]--; // 让头指针移动，直到移动到和s.charAt(j)上字符同的时候，s.charAt(j)字符个数-1；
            }
            if(j-i+1 > max)  // 新的 i 和  j 的位置差是否大于最大间距；
                max = j-i+1;
        }
        return max;
    }
}

