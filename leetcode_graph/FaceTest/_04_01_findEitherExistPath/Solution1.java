package FaceTest._04_01_findEitherExistPath;

// 题目： 节点间通路。
//        给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
//示例1:
//      输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
//      输出：true

//  思路一：DFS;(BFS也可以)

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> list = new ArrayList<>();
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 构建每个数的有向图链表（每个数可到的点的集合）
        for(int i = 0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] arr : graph){
            list.get(arr[0]).add(arr[1]);
        }
        return DFS(start,target);
    }
    // 深度递归；
    public boolean DFS(int start,int target){
        // 查找起始点的集合中是否包含目标点；
        if(list.get(start).contains(target)) return true;
        // 深度遍历起始点的目的点的集合；
        for(int num:list.get(start)){
            // 找到返回 true; 找不到继续下一个结点；
            if(DFS(num,target)) return true;
        }
        // 深度遍历完没找到，返回false;
        return false;
    }
}
