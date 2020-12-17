package leetcode_058_lastWordLength;

//  题目: 最后一个单词的长度;
//  描述: 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
//          如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//            如果不存在最后一个单词，请返回 0 。

//说明：  一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//

public class Solution1 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        String newS = s.trim();
        if(newS.length() == 0) return 0;
        int count = 0;
        for(int i = newS.length()-1;i>=0 && newS.charAt(i)!=' ';i--){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = "a ";
        int num = solution1.lengthOfLastWord(s);
        System.out.println(num);
    }
}
