package Face_test.String_test.isValid;

import java.util.HashMap;
import java.util.LinkedList;

// 题目：
//       给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
//       括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

public class Solution1 {
    public boolean isValid (String s) {
        int len = s.length();
        if(len == 0) return true;
        // 这里注意： HashMap<Character,Character> map = new HashMap()<>{} 错误的，不能加 <>；
        HashMap<Character,Character> map = new HashMap(){
            {
                put('(',')');
                put('[',']');
                put('{','}');
            }
        };
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0;i<len;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                stack.add(ch);
                continue;
            }else{
                if(stack.isEmpty() || map.get(stack.pollLast()) != ch) return false;
            }
        }
        return stack.isEmpty();
    }
}
