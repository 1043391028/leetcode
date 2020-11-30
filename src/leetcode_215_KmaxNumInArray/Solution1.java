package leetcode_215_KmaxNumInArray;

//   题目： 数组中第 k 大的元素；
//   描述： 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
//          而不是第 k 个不同的元素。
//  示例 1:
//          输入: [3,2,1,5,6,4] 和 k = 2
//          输出: 5

//    思路一：大顶堆，效率稍低；击败36%；（solution2稍微优化，维护一个容量为 K+1 的优先队列，但是整体并无大区别）
//    最优解：思路三（solution3）快排思路（要掌握）
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int num:nums){
            queue.offer(num);
        }
        for(int i = 0; i < k-1;i++){
            queue.remove();
        }
        return queue.peek();
    }
}
