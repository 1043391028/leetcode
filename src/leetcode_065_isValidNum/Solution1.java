package leetcode_065_isValidNum;

//  题目： 有效数字；
//   描述: 验证给定的字符串是否可以解释为十进制数字。
//
//   例如:
//          "0" => true
//           " 0.1 " => true
//          "abc" => false
//          "1 a" => false
//           "2e10" => true
//        " -90e3   " => true
//          " 1e" => false
//          "e3" => false
//           " 6e-1" => true
//         " 99e2.5 " => false
//         "53.5e93" => true
//         " --6 " => false
//          "-+3" => false
//         "95a54e53" => false
//
//  说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
//
//        数字 0-9
//        指数 - "e"
//        正/负号 - "+"/"-"
//          小数点 - "."
//        当然，在输入中，这些字符的上下文也很重要。

public class Solution1 {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        char[] charArr = s.trim().toCharArray();
        boolean num = false , dot= false, exp= false, numAfterE = false;
        int len = charArr.length;

        for(int i = 0; i< len;i++){
            char ch = charArr[i];
            if(ch == '.'){
                if(dot || exp) return false;
                dot = true;
            }else if(ch == 'e'){
                if(exp || !num) return false;
                exp = true;
                numAfterE = false;
            }else if(ch == '-' || ch == '+'){
                if(i>0 && charArr[i-1]!='e' || charArr[i-1] != ' ') return false;
            }else if(ch >='0' && ch <='9'){
                num = true;
                numAfterE = true;
            }else
                return false;
        }
        return num && numAfterE;
    }

    // 测试;
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = "  ";
        boolean m = solution1.isNumber(s);
        System.out.println(m);
    }
}
