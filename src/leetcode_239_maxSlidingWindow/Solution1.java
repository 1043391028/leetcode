package leetcode_239_maxSlidingWindow;

//   题目: 滑动窗口的最大值;
//   描述: 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
//          你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。 
//   进阶：
//        你能在线性时间复杂度内解决此题吗？
//
// 思路一: 双端队列;(很多细节)

import java.util.LinkedList;

public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 长度为1或者空就直接返回数组;
        if(nums == null || nums.length < 2) return nums;
        // 初始数组,长度为数组长度 len-k+1;
        int[] res = new int[nums.length - k+1];
        // 新建双端队列;
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 0;i < nums.length;i++){
            // 下面条件一定要注意是 nums[i] >= nums[deque.peekLast];
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            // 队首元素下标是否出界;
            while(deque.peek() <= i-k){
                deque.removeFirst();
            }
            // 判断当前遍历的位置是否过 k-1;
            if(i >= k-1){
                res[i-k +1] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {7,2,4};
        int[] res = new int[nums.length];
        res = solution.maxSlidingWindow(nums,2);
        for(int num:res){
            System.out.println(num);
        }

    }

}
