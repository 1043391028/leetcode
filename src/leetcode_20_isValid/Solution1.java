package leetcode_20_isValid;

//     题目： 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//     有效字符串需满足：
//
//                    左括号必须用相同类型的右括号闭合。
//                     左括号必须以正确的顺序闭合。
//                     注意空字符串可被认为是有效字符串
//         思路： 利用HashMap(保存键值对，对应括号对) 和Stack，保存字符串入队后的顺序，
//                然后对字符串遍历，为左边键'(','[','{',就加入到栈，不是就检查目前遍历位置字符串是否是栈顶键值对对应的值；

import java.util.HashMap;
import java.util.LinkedList;

public class Solution1 {
//     建立HashMap 保留对应的括号对；为了后面检查；
    private static final HashMap<Character,Character> map = new HashMap<Character, Character>() {{
        put('(', ')') ; put('{' , '}') ; put('[',']');
    }};
//     方法函数：
        public boolean isValid(String s){
        //     对于第一个字符为
            LinkedList<Character> stack = new LinkedList<Character>() {{
                add('?');
            }};
            for (Character c : s.toCharArray() ) {
                if(map.containsKey(c)) stack.add(c);
                else if(map.get(stack.removeLast()) != c) return false;
            }
            return stack.size() == 1 ;
        }
}
