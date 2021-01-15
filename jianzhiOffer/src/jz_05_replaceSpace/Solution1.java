package jz_05_replaceSpace;

//  题目： 替换空格；
//  描述： 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
// 示例 1：
//         输入：s = "We are happy."
//         输出："We%20are%20happy."
//
//  思路一： 直接遍历替换；
//         时间复杂度：o(n);
//         空间复杂度：0(n);
//   注意： 库函数也可以实现： return s.replace(" ","%20");

public class Solution1 {
    public String replaceSpace(String s) {
        int len = s.length();
        if(len == 0 ) return s;
        StringBuilder sb = new StringBuilder();
        for(int i= 0;i<len;i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
