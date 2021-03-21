package lc_802_evemtureSafeNodes;

// 题目： 找到最终的安全状态；
//        在有向图中，从某个节点和每个转向处开始出发，沿着图的有向边走。如果到达的节点是终点（即它没有连出的有向边），则停止。
//
//        如果从起始节点出发，最后必然能走到终点，就认为起始节点是 最终安全 的。更具体地说，对于最终安全的起始节点而言，
//           存在一个自然数 k ，无论选择沿哪条有向边行走 ，走了不到 k 步后必能停止在一个终点上。
//
//         返回一个由图中所有最终安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
//
//         该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：
//            graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
//  输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//  输出：[2,4,5,6]
//  解释：示意图如上。

// 思路一：
//         有向图；从入度为 0 的结点开始，倒着找只能经过该节点的结点（这些结点都是安全的）

import java.util.*;

public class Solution1 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        List<HashSet<Integer>> Gra = new ArrayList<>();
        List<HashSet<Integer>> reGra = new ArrayList<>();
        for(int i = 0;i<len;i++){
            Gra.add(new HashSet<>());
            reGra.add(new HashSet<>());
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < len;i++){
            if(graph[i].length == 0){
                queue.add(i);
            }
            for(int j:graph[i]){
                Gra.get(i).add(j);
                reGra.get(j).add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(queue.size() != 0){
            int temp = queue.poll();
            res.add(temp);
            Set<Integer> list = reGra.get(temp);
            for(int i : list){
                Gra.get(temp).remove(i);
                if(Gra.get(temp).size() == 0) queue.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }
}
