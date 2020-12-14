package leetcode_014_longestCommonPreString;

//  题目： 最长公共前缀；
//  描述： 编写一个函数来查找字符串数组中的最长公共前缀。
//
//         如果不存在公共前缀，返回空字符串 ""；
//示例 1:
//         输入: ["flower","flow","flight"]
//         输出: "fl"
//
//  思路一： 横向比较；
//          两个两个比较，比较完再截取相同部分组成新的字符串继续和下一个字符串比较，直到比较完最后一个
//            中间如果出现字符串为""（空）直接返回；

public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0) return "";
        int len = strs.length;
        // 初始化对比字符串为第一个字符串，然后依次和后面对比；
        String str = strs[0];
        for(int i = 1;i < len;i++){
            int j = 0;
            for(; j<str.length() && j< strs[i].length();j++){
                if(str.charAt(j) != strs[i].charAt(j)) break;
            }
            str = str.substring(0,j);
            if(str.length() == 0) return str;
        }
        return str;
    }
}
