package leetcode_207_ifCanFinishAllClass;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//  题目: 课程表
//  描述: 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//
//        在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//
//        给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
//
//  思路一: bfs(题中解析)
public class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        // 定义入度课程数组(一共有多少科,就定义多大数组),有可能有的课程入度为0,即没有前提课程;
        int[] inContent = new int[numCourses];
        // 保存一个关系(邻接)链表,每一个课程,和其后继课程(每当出队一次,需将相应的每一个后继课程数减1)
        List<List<Integer>> list = new ArrayList<>();
        // 双端队列,只保存入度为 0 的课程;在不断更新;
        Deque<Integer> deque = new LinkedList<>();
        // 初始化邻接链表,个数为numCourses(即一共多少课程)
        for(int i= 0;i<numCourses;i++){
            list.add(new ArrayList<Integer>());
        }
        for (int[] ints : prerequisites) {
            inContent[ints[0]]++;
            // 最难理解的地方,相当于把前驱课程(ints[1])位置的链表加入后继结点(ints[0])
            list.get(ints[1]).add(ints[0]);
        }

        for(int i=0;i<numCourses;i++){
            if(inContent[i] == 0) deque.add(i);
        }

        while(!deque.isEmpty()){
            int temp = deque.poll();
            numCourses--;
            for(int out:list.get(temp)){
                inContent[out]--;
                if(inContent[out]==0) deque.add(out);
            }
        }
        return numCourses == 0;
    }
}
