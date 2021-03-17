package lc_227_Caculation2;

//  思路二： 万能计算法：双栈（包括带括号的）

//  大致思路：

import java.util.*;

public class Solution2 {
    Map<Character,Integer> map = new HashMap<Character, Integer>(){
        {
            put('+',1);
            put('-',1);
            put('*',2);
            put('/',2);
            put('%',2);
            put('^',3);
        }
    };
    public int calculate(String s) {
        s.replaceAll(" ", "");
        s.replaceAll("\\(-", "(0-");
        int len = s.length();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> chars = new ArrayDeque<>();
        nums.addLast(0); //
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                chars.addLast(ch);
            } else if (ch == ')') {
                while (!chars.isEmpty()) {
                    if (chars.peekLast() != '(') {
                        cal(nums, chars);
                    } else {
                        chars.pollLast();
                        break;
                    }
                }
            } else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) num = num * 10 + s.charAt(i++) - '0';
                i--;
                nums.addLast(num);
            } else {
                while (!chars.isEmpty() && chars.peekLast() != '(' && map.get(chars.peekLast()) >= map.get(ch))
                    cal(nums, chars);
                chars.addLast(ch);
            }
        }
        while(!chars.isEmpty()) cal(nums,chars);
        return nums.peekLast();
    }


    public void cal(Deque<Integer> nums,Deque<Character> chars){
         int a = nums.pollLast(),b = nums.pollLast();
         char ops = chars.pollLast();
         int ans = 0;
         switch(ops){
             case '+':ans = b+a;break;
             case '-':ans = b-a;break;
             case '*':ans = b*a;break;
             case '/':ans = b/a;break;
             case '%':ans = b%a;break;
             case '^':ans = (int)Math.pow(b,a);
        }
        nums.addLast(ans);
    }
}
