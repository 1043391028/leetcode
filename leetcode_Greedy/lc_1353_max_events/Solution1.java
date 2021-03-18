package lc_1353_max_events;

import leetcode_018_sumOfFourNum.Solution;

import java.util.Arrays;
import java.util.PriorityQueue;

// 题目： 最大会议数；（注意：这题是每个区间内 '任意一天' 参加会议都行，而不是要错开区间）

//   描述： 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
//
//               你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
//
//         请你返回你可以参加的 最大 会议数目。
//
//    核心思路：
//             小顶堆 + 排序；
//              数组按照 开始天数排序（从小到大），遍历数组，将开始天数一样的 结束天数加到小顶堆；
//
public class Solution1 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        //小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //结果、开始时间、events下标、有多少组数据
        //  last 代表的就是当天天数（第几天）
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            //将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            //pop掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            //顶上的就是俺们要参加的（顶上代表此时最早结束的）
            //  下面代表的意思就是，第 last 天参加以小顶堆中最早结束的那场会议；（贪心思想在这里，先参加结束早的）
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            last++;
        }
        return res;
    }

    //测试：
    public static void main(String[] args) {
        int[][] arr = {{1,6},{2,3},{4,5},{5,5},{6,6}};
        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,3}};
        Solution1 solution1 = new Solution1();
        int res = solution1.maxEvents(events);
        System.out.println("最多参加的会议数："+res);
    }

}
