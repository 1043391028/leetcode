package leetcode_028_StrStr;

//  题目： 实现strstr;
//  描述： 实现 strStr() 函数。
//
//         给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串
//            出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//示例 1:
//         输入: haystack = "hello", needle = "ll"
//         输出: 2
//
//  思路一： 暴力匹配；
      //   需要注意边界条件；

public class Solution1 {
    public int strStr(String haystack, String needle) {
        if (haystack != null && haystack.equals(needle)) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int hLen = haystack.length(), nLen = needle.length();
        for(int i = 0;i< hLen -nLen +1;i++){
            for(int j = 0;j < needle.length();j++){
                if( haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if(j == nLen-1) return i;
            }
        }
        return -1;
    }
}
