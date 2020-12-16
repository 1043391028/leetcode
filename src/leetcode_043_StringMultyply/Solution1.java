package leetcode_043_StringMultyply;

//   题目： 字符串相乘；
//   描述： 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//          输入: num1 = "2", num2 = "3"
//          输出: "6"

//     思路： 竖式相乘；

public class Solution1 {
    public String multiply(String num1, String num2) {
        // 判空
        if( num1.length() == 0 || num2.length() == 0) return "";
        // 判断其中一个字符串为“0” 的情况，这样返回"0" ,不判断可能返回"000"等多位（取决于其中不为"0"字符串的长度）
        if(num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length(),  len2 = num2.length();
        int[] res = new int[len1 + len2];
        // 从高位往低位计算；
        for(int i =len1-1;i>=0;i--){
            int ch1 = num1.charAt(i)-'0';
            for(int j = len2-1;j>=0;j--){
                int ch2 = num2.charAt(j) - '0';
                int temp = res[i+j+1] + ch1*ch2; // 这一步把上一次计算代表低位同一位的+上后的结果；
                res[i+j+1] = temp%10 ; // 代表低位；两个字符串都是从右往左遍历；
                res[i+j] += temp/10 ; // 代表高位； += 是因为，需要把之前计算结果在同位的+进去，
                                        // 而res[i+j]保存的有上一次大循环计算的结果；
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < res.length;i++){
            if(i==0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s1 = "234" , s2 = "99";
        String s3 = solution1.multiply(s1,s2);
        System.out.println(s3);
    }
}
