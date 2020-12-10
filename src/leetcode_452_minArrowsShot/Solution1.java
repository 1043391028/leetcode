package leetcode_452_minArrowsShot;

//   题目： 最少数量的箭引爆气球；
//   描述： 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，
//           气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。
//          开始坐标总是小于结束坐标。
//
//        一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，
//       若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，
//         则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
//          我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
//
//给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
//
//    思路：1. 把数组按照左边界或者右边界排序；
//          2. 定义初始计数count = 1, 初始数 pre= 第一个数组右边界（最小的），
//              依次和下一个数组左边界对比，（只要左边界<pre，说明一置箭可以射穿）
//               一旦小于（需要新增一支箭），count++; 并将右边界更让新为新的数组右边界；

import java.util.Arrays;

public class Solution1 {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length ==0) return 0;
        Arrays.sort(points,(o1, o2)->o1[1]>o2[1]?1:-1);
        int count = 1;
        int pre = points[0][1];
        for(int[] array : points){
            if(pre < array[0]){
                count++;
                pre = array[1];
            }
        }
        return count;
    }
}
