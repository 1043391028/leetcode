package leetcode_014_longestCommonPreString;

//   思路二： 纵向比较；
//           将所有字母共同位置的字母对比，直到出现不同的停止；

public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0) return "";
        String str = strs[0]; // 第一个字符串为基准；
        int len = str.length();
        for(int i = 0;i < len;i++){
            char ch = str.charAt(i);
            // 依次比较剩下字符串相同位置的字母是否相等；
            for(int j=1;j < strs.length;j++){
                // 不相等或者 超出当前字符串长度，截取到 i 位置并返回；
                if(i == strs[j].length() || strs[j].charAt(i) != ch ) return str.substring(0,i);
            }
        }
        return str;
    }
}
