package lc_1387_GetKth;

//  题目： 将整数按照权重排序；
//
//  思路：
//

import java.util.PriorityQueue;

public class Solution1 {
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> queue  = new PriorityQueue<>((o1,o2)->o2[1]==o1[1]?o2[0]-o1[0]:o2[1]-o1[1]);
        for(int i = lo;i<=hi;i++){
            int Weight = DFS(i,0);
            // 这里注意，一定要先放入优先队列，然后判断队列元素个数是否 > K;
            //   不能先判断 == k,然后加入队列新的元素，这样就不能排序出队那个和新入队元素的权重大小了；
            //    if（queue.size() == k） queue.poll();
            //     queue.offer(new int[]{i,Weight});
            queue.offer(new int[]{i,Weight});
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek()[0];
    }
    public int DFS(int i,int start){
        if(i == 1) return start;
        if(i%2 == 1) {
            return DFS(3*i+1,start+1);
        }
        return DFS(i/2,start+1);
    }
}
