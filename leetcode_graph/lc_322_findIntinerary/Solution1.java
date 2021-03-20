package lc_322_findIntinerary;

// 题目： 重新安排行程；
// 描述： 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
//       对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。

//提示：
//       如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。
//       例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
//       所有的机场都用三个大写字母表示（机场代码）。
//       假定所有机票至少存在一种合理的行程。
//       所有的机票必须都用一次 且 只能用一次。 
//示例 1：
//       输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//       输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
//
// 思路： DFS + HashMap + PriorityQueue;
//          要用头插法； dfs遍历直到遇到最后一个孤岛结点（只有进没有出），首先将该节点加入
//              退出该层返回上层的时候，将上一层访问结点加到（第一个位置）
//                 这样就能保证我们最后一个访问的是孤岛结点，从而可以到达所有结点；
//        此思路接用 优先队列 priorityQueue 按照字典序进行将临结点排序；
//

import java.util.*;

public class Solution1 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        Map<String,PriorityQueue<String>> map = new HashMap<>();
        for(List list:tickets){
            if(!map.containsKey(list.get(0))){
                // 这里注意要转写成String类型；
                map.put((String)list.get(0),new PriorityQueue<String>());
            }
            map.get(list.get(0)).add((String)list.get(1));// 这里注意要转成String类型；
            // 另一种写法；
            // PriorityQueue<String> queue = map.computeIfAbsent((String)list.get(0),K->new PriorityQueue<String>());
            // queue.add((String)list.get(1));
        }
        DFS(res,map,"JFK");
        return res;
    }
    // DFS遍历；
    public void DFS(List<String> res,Map<String,PriorityQueue<String>> map,String str){
        PriorityQueue<String> temp = map.get(str);
        while(temp != null && temp.size() > 0){
            String s = temp.poll();
            DFS(res,map,s);
        }
        res.add(0,str);
    }
}
