package lc_0524_findLongestString;

import java.util.List;

//  题目：通过删除字母匹配到字典里的最长单词；
//   描述: 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
//           如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
// 示例 1:
//   输入:
//        s = "abpcplea", d = ["ale","apple","monkey","plea"]
//   输出:
//        "apple"
//   思路：
//         双指针；

public class Solution1 {
    public String findLongestWord(String s, List<String> dictionary) {
        // res 保存结果字符串；
        String str = "";
        //  遍历 list 中的字符串，并判断是否可以通过删除 s 字符串中的字母得到，
        //    同时选出 比较满足的最长且字典序最靠前的字符串；
        for(String temp : dictionary){
            for(int i=0,j=0;i<s.length()&&j < temp.length();i++){
                if(temp.charAt(j) == s.charAt(i)) j++;
                // 如果 j  == temp字符串长度，则满足s字符串删除字母得到temp（list中的字符串）
                if(j == temp.length()){
                    // 比较和前面的到的字符串长度，长度一样按照字典序比较
                    if(temp.length() > str.length() || (temp.length() == str.length() && str.compareTo(temp)>0))
                        str = temp;
                }
            }
        }
        return str;
    }
}
