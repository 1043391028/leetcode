package leetcode_207_ifCanFinishAllClass;

// 思路二: Dfs(深度优先)

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 新建邻接表;
        List<List<Integer>> adjacency = new ArrayList<>();
        // 初始化邻接表个数;
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
//        标记数组,标记课程是否被遍历,是否符合要求;
//        三种情况：0：未遍历；
//                 1： 本轮已经遍历，如果再次进入，则说明有循环，返回false;
//                -1： 遍历过，并已经退出该轮循环；返回true;
        int[] flags = new int[numCourses];
//        初始化临界表；
        for(int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
//        深度遍历；i代表每一个课程，循环遍历，实际上在深度遍历时，很多点都已经在前面的几个点中遍历过；
        for(int i = 0; i < numCourses; i++)
            if(!dfs(adjacency, flags, i)) return false; // 如果能出循环说明所有的点都已经遍历，并且没有错；下面直接就可以返回true;
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        // 三种情况对应三种状态；并返回相应的结果；
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(Integer j : adjacency.get(i))
            if(!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }
}
