package leetcode_20_isValid;

//    结合方法一的思路； 不用 HashMAp 的做法；

import java.util.LinkedList;

public class Solution2 {
    public boolean isValid(String s){
        LinkedList<Character> stack = new LinkedList<Character>();
        for (Character c: s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }
            else if(stack.size() == 0||stack.removeLast() != c ) // 这里判断一定注意顺序，先判断是否为空，后判断是否相等；
                return false;
        }

        return stack.size() == 0;
    }
//    if(s.isEmpty())
//            return true;
//        Stack<Character> stack=new Stack<Character>();
//        for(char c:s.toCharArray()){
//            if(c=='(')
//                stack.push(')');
//            else if(c=='{')
//                stack.push('}');
//            else if(c=='[')
//                stack.push(']');
//            else if(stack.empty()||c!=stack.pop())
//                return false;
//        }
//        if(stack.empty())
//            return true;
//        return false;

}
