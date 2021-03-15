package lc_921_midAddToValid;

// 题目： 使括号有效的最少添加；
//       给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
//
//        从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
//
//                   它是一个空字符串，或者
//                   它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
//                   它可以被写作 (A)，其中 A 是有效字符串。
//      给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
//
//示例 1：
//        输入："())"
//        输出：1
//
//  思路提示： 遍历字符串，只需要统计最后需要添加的 '(' 个数：right，')' 个数 left;

public class Solution2 {
    public int minAddToMakeValid(String S) {
        int len = S.length();
        int left = 0,right = 0;
        for(int i=0;i<len;i++){
            left += S.charAt(i)=='('?1:-1;
            // left == -1;说明需要补充‘）’ right++;同时消去'(' left++（变为 0）;
            if(left == -1){
                left++;
                right++;
            }
        }
        return left+right;
    }
}
