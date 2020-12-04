package leetcode_301_deleteInvalidparenthes_;

//    题目： 删除无效括号；
//    描述： 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
//
//    说明: 输入可能包含了除 ( 和 ) 以外的字符。
//
//  示例 1:
//          输入: "()())()"
//          输出: ["()()()", "(())()"]
//
//  思路一： Dfs；

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        if(s == null ) return null;
        int left = 0, right = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                left++;
            }
            if(ch == ')'){
                if(left > 0) left--;
                else right++;
            }
        }
        dfs(s,0,left,right);
        return res;
    }

    public void dfs(String s,int st,int left,int right){
        if(left == 0 && right == 0){
            if(check(s)){
                res.add(s);
            }
            return ;
        }
        for(int i= st;i <s.length();i++){
            if(i-1>=st && s.charAt(i) == s.charAt(i-1)) continue;
            // java截取长度的函数 subString(int start,int length) 第二个参数是长度，左闭右开；
            if(s.charAt(i) == '(' && left>0) {
                dfs(s.substring(0, i) + s.substring(i + 1, s.length() - i + 1), i, left - 1, right);
            }
            if(s.charAt(i)== ')' && right>0) {
                dfs(s.substring(0, i) + s.substring(i + 1, s.length() - i + 1), i, left, right - 1);
            }
        }
    }

    public boolean check(String s){
        int left = 0,rihgt = 0;
        for(char ch:s.toCharArray()){
            if(ch == '('){
                left++;
            }else if(ch == ')'){
                left--;
                if(left < 0) return false;
            }
        }
        return left == 0;
    }

}
