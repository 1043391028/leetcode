package leetcode_067_BinarySum;

//  题目: 二进制求和;
//  描述: 给你两个二进制字符串，返回它们的和（用二进制表示）。
//
//        输入为 非空 字符串且只包含数字 1 和 0。

//示例 1:
//        输入: a = "11", b = "1"
//        输出: "100"
//  思路: 从后往前遍历两个串每个字符并相加,处理相加后的结果,保存到结果字符串缓冲串res; 最后反转字符串;
//        具体细节在题中解释;
//
public class Solution1 {
        public String addBinary(String a,String b){
            // 其中一个串长度为 0,就直接返回另一个串;
            if(a.length() == 0) return b;
            if(b.length() == 0) return a;
            int LenA = a.length(),lenB = b.length();
            StringBuilder res = new StringBuilder();
            // 保存进位结果,初始化为0;
            int carry = 0;

            for(int i = LenA-1, j = lenB-1;i >= 0 || j>= 0;i--,j--){
                // 进位结果分别加上 两个字符串当前位的大小;
                carry += i>= 0?a.charAt(i)-'0':0;
                carry += j>= 0?b.charAt(j)-'0':0;
                //  得到结果carry%2 保存到当前位;
                res.append(carry%2);
                // carry/2 可表示进位;
                carry /= 2;
            }
            // 最后跳出循环,如果进位为 1, 则需要 在结果中添加'1';
            res.append(carry == 1?carry:"");
            // 反转字符串;
            return res.reverse().toString();
        }
}
