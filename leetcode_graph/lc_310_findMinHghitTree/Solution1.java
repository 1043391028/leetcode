package lc_310_findMinHghitTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 题目： 最小高度树；
//  描述： 略；
//  思路： 无向图；
//           遍历数组；统计各个点的出度；并且将每一个点的 临结点保存到链表；
//          最后用广度便利的方法一层一层的将出度为 1 的加入到队列；
//             遍历队列，直到为空；（便利的过程将出队列的点加到结果集，最后一层出队列的点就是所求的结果）

public class Solution1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        int[] out = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] arr : edges){
            out[arr[0]]++;
            out[arr[1]]++;
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(out[i] == 1) queue.offer(i);
        }

        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int temp = queue.poll();
                res.add(temp);
                for(int j : graph.get(temp)){
                    out[j]--;
                    if(out[j] == 1) queue.offer(j);
                }
            }
        }
        return res;
    }
}
