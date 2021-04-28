package src.Face_test._001_MostPopular._038_CalcutationRes;

// 题目： 计算器；
//  描述： 请写一个整数计算器，支持加减乘三种运算和括号。

//  思路一： 辅助栈 + 递归；
//

import java.util.Stack;

public class Solution1 {
    public int solve (String s) {
        // write code here
        String str = s.trim();
        int len = str.length();
        char sign = '+';
        int num = 0, res = 0;
        // 辅助栈，栈里保存数字；
        Stack<Integer> stack  = new Stack<Integer>();
        for(int i = 0;i<len;i++){
            char ch = str.charAt(i);
            if(ch == ' ') continue;
            if(ch >= '0' && ch<=9){
                num = num*10 + ch - '0';
            }
            if(ch == '('){
                int countKuohao = 1,j=i+1;
                while(countKuohao > 0){
                    if(str.charAt(j) == '(') countKuohao++;
                    if(str.charAt(j) == ')') countKuohao--;
                    j++;
                }
                num = solve(str.substring(i+1,j-1));
                i = j-1;
            }
            if (!Character.isDigit(ch) || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-1 * num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = ch;
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
