package leetcode_215_KmaxNumInArray;

// 优化小顶堆：
//           使优先队列的容量设置为K+1；（但是效率依然不高）

import java.util.PriorityQueue;
public class Solution2 {
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1,(o1,o2)->o1-o2);
        for(int i= 0;i < k;i++){
            queue.offer(nums[i]);
        }
//      第 k+1 个元素,进一次，出来，最后队列顶部就是第 k 大元素，队列里面的都比队顶大；
        for(int i=k;i<nums.length;i++){
            queue.offer(nums[k]);
            queue.poll();
        }
        return queue.peek();
    }
}
