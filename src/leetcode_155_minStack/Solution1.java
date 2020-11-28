package leetcode_155_minStack;

//   题目: 最小栈;
//   描述: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//         push(x) —— 将元素 x 推入栈中。
//         pop() —— 删除栈顶的元素。
//         top() —— 获取栈顶元素。
//         getMin() —— 检索栈中的最小元素。
//  思路一:   (辅助栈)
//           这里采用同步辅助栈的方法;(即数据栈和最小值栈同时出栈和入栈)
//           核心: 辅助栈入栈时是 当前值和辅助栈栈顶最小值;这样辅助栈栈顶始终保存的是最小值;
//
import java.util.Stack;

public class Solution1 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> helpStack;

        public MinStack() {

            stack = new Stack<Integer>();
            helpStack = new Stack<Integer>();
            helpStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            // helpStack.push(Math.min(x,helpStack.peek));
            if(x <= helpStack.peek()){
                helpStack.push(x);
            }else{
                helpStack.push(helpStack.peek());
            }
        }

        public void pop() {
            helpStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return helpStack.peek();
        }
    }

}
