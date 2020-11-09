package leetcode_42_trapWater;

//     思路5： 栈；
//

import java.util.LinkedList;
import java.util.Stack;

public class Solution5 {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int sum = 0, cur = 0;
        while(cur < height.length){
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.isEmpty()) { // 栈空就出去
                    break;
                }
                int distance = cur - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[cur]);
                sum = sum + distance * (min - h);
            }
            stack.push(cur); //当前指向的墙入栈
            cur++; //指针后移
        }
        return sum;
    }
}
