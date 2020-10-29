package leetcode_05_longestHuiWenString;

//      题目描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

//       实例： 输入: "babad"
//             输出: "bab"
//             注意: "aba" 也是一个有效答案。

//       暴力解法：  从头开始遍历，并且，遍历过程利用辅助函数判断当前字符序号到最后一个字符位置是否为回文序列；
//       时间复杂度： O(N^3)，这里 NN 是字符串的长度，枚举字符串的左边界、右边界，然后继续验证子串是否是回文子串，
//                   这三种操作都与 NN 相关；
//       空间复杂度： O(1)，只使用到常数个临时变量，与字符串长度无关。

public class solution1 {
    public String longestHuiWenString(String s){
        int len = s.length();
        if(len < 2) return s;

        char[] charArray = s.toCharArray();
        int maxsublen = 1;
        int start = 0;
        for(int i = 0 ;i < len - 1; i++){
            for(int j = i+1 ; j< len ; j++){
                if(j-i+1 > maxsublen && jugdeHuiwen(charArray,i,j)){
                    start = i;
                    maxsublen = j-i+1;
                }
            }
        }
        return s.substring(start,start + maxsublen);
    }

    boolean jugdeHuiwen(char[] charArray , int start , int end){
        while(start < end){
            if(charArray[start] != charArray[end]){
                return false;
            }else {
                start++;
                end--;
            }
        }
        return true;
    }

}
