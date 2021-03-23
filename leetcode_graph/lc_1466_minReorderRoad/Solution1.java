package lc_1466_minReorderRoad;

// 题目：  重新规划路线；
//  描述： n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。
//         因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。
//          去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
//
//        路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
//
//        今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
//
//         请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
//
//       题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
//
//  思路：

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> map = new ArrayList<>();
        int len = connections.length;
        for(int i = 0;i < n;i++){
            map.add(new ArrayList<>());
        }
        //  将第 i 组（每组两个城市，这两个城市其中一个含有 i）也就是将城市 i 和另外一个城市（相邻的）关联起来；
        for(int i = 0;i<len;i++){
            map.get(connections[i][0]).add(i);
            map.get(connections[i][1]).add(i);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int ans = 0;
        boolean[] visited  = new boolean[len];
        while(!queue.isEmpty()){
            // node 代表城市
            int node  = queue.poll();
            // visited[node] = true; 这一步不能要
            List<Integer> temp = map.get(node); // 这一步得到所有和 node 城市相关（临）的城市；
            // 遍历和node(0 ~ n-1)个城市相关的城市（连接的城市）
            for(int index : temp){
                if(!visited[index]){
                    int first = connections[index][0];
                    int second = connections[index][1];
                    ans += node == first?1:0;
                    visited[index] = true;
                    queue.add(first == node?second:first);
                }
            }
        }
        return ans;
    }
}
