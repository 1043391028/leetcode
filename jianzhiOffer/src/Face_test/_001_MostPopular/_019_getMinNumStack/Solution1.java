package src.Face_test._001_MostPopular._019_getMinNumStack;

//  题目： getMin功能的栈；
//   描述： 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
//   思路提醒：

import java.util.Stack;

public class Solution1 {
    public class Solution {
        /**
         * return a array which include all ans for op3
         * @param op int整型二维数组 operator
         * @return int整型一维数组
         */
        public int[] getMinStack (int[][] op) {
            // write code here
            int count = 0;
            for(int[] arr:op){
                if(arr[0] == 3) count++;
            }
            int[] res = new int[count];
            int index = 0;
            
            Stack<Integer> minStack = new Stack<>();
            Stack<Integer> stack = new Stack<>();
            //minStack.push(Integer.MAX_VALUE);
            for(int[] arr: op){
                int key = arr[0];
                switch(key){
                    case 1:
                        stack.push(arr[1]);
                        if(minStack.isEmpty()||arr[1]<=minStack.peek()) minStack.push(arr[1]);
                        break;
                    case 2:
                        if(minStack.peek()>=stack.pop()){
                            minStack.pop();
                        }
                        break;
                    case 3:
                        res[index++] = minStack.peek();
                }
            }
            return res;
        }
    }
}
