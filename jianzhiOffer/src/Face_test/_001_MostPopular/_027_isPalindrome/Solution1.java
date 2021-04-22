package src.Face_test._001_MostPopular._027_isPalindrome;

//   题目： 判断数字是否是回文数字；
//   注意 ：  负数情况；

// 思路一：
//          双端队列；

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    public boolean isPalindrome (int x) {
        // write code here
        //if(x<0 || (x!=0 && x%10 == 0)) return false;
        if(x<0) return false;
        Deque<Integer> deque = new ArrayDeque<>();
        while(x>0){
            deque.add(x%10);
            x /=10;
        }
        while(deque.size()>1){
            if(deque.pollLast() != deque.pollFirst()) return false;
        }
        return true;
    }
}
