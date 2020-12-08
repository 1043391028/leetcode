package leetcode_739_DailyTempreture;

import java.util.Stack;

//   思路二:  栈
//            遍历数组, 将元素对应的下标入栈,如果当前元素 i 大于栈顶元素(下标j)对应的元素,
//            出栈,新建一数组res(保存结果), 保存弹出栈的序号对应的res[j] = i-j;
//             一直出栈并保存,直到栈顶元素大于当前元素,把当前元素入栈;
//   思路三:
//             暴力遍历数组,从后往前,通过遍历过的结果求后面未遍历的结果;

public class Solution1 {
    public int[] dailyTemperatures(int[] T) {
        // 新建栈,保存下标,下标对应的元素递减;
        Stack<Integer> stack  = new Stack<>();
        //新建数组,保存结果;
        int len = T.length;
        int[] res = new int[len];
        // 遍历数组
        for(int i = 0;i<len;i++){
            // 更新栈
            while(!stack.isEmpty() && T[stack.peek()]<T[i]){
                int j =stack.pop();
                res[j] = i-j;
            }
            stack.push(i);
        }
        return res;
    }
}
