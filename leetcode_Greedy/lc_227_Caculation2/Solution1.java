package lc_227_Caculation2;

// 题目： 基本计算器II;
//  描述： 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
//         整数除法仅保留整数部分。
//示例 1：
//         输入：s = "3+2*2"
//         输出：7
//示例 2：
//         输入：s = " 3/2 "
//         输出：1
//  思路一：


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution1 {
    public int calculate(String s) {
        //Stack<Integer> stack = new Stack<>();
        // 栈保存数字；
        Deque<Integer> stack = new ArrayDeque<>();
        int len = s.length();
        // res 计算结果； num  保存暂时的数字（某一段连续的数字）
        int res = 0,num = 0;
        // 提前保存一个符号；
        char sign = '+';
        // 遍历字符串；
        for(int i = 0;i<len;i++){
            char ch = s.charAt(i);
            // 如果是数字，就更新 num；
            if(ch >= '0'){
                num = num*10 - '0' + ch;
            }
            // 判断如果是 +、—（数字入栈），*、/（就先计算，将栈顶数字出栈，与当前数字计算，结果再入栈）；
            if((ch < '0' && ch != ' ')||i == s.length()-1)
            {
                switch(sign){
                    case '+': stack.push(num);  break;
                    case '-': stack.push(-num);  break;
                    case '*': stack.push(stack.pop()*num); break;
                    case '/': stack.push(stack.pop()/num); break;
                }
                sign = ch;
                num = 0;
            }
        }
        // 最后数字栈中剩余的都是+或者-（负数），直接一个个出栈相加就行；
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
