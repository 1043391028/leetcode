package leetcode_57_insertArray;

//  题目： 插入区间；
//  描述： 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
//         在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

//示例 1：
//          输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//          输出：[[1,5],[6,9]]
//   思路：
//        分三段遍历数组：数组已经按照左边界升序排好序（可直接遍历）；
//      1. 第一阶段： 当前数组 区间右边界 < 插入数组左边界（说明没有交集），直接将数组添加进res(结果数组)；
//      2. 第二阶段： 当前数组 区间右边界肯定 >= 插入数组的左边界，不断更新新数组边界（合并），直到当前遍历数组左边界 > 新数组右边界；
//      3. 第三阶段； 将后面区间依次添加进res;


import java.util.Arrays;

public class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || newInterval == null )
            return null;
        // 新建结果数组，第一维长度为 intervals.length +1，有可能插入的区间不和任何区间重合；
        int[][] res = new int[intervals.length+1][2];
        int index = 0 , i = 0;
        // 第一阶段: 添加前面 相离数组区间；
        while(i < intervals.length && intervals[i][1]<newInterval[0]){
            res[index++] = intervals[i++];
        }
        // 第二阶段：合并插入区间到数组；
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res[index++] = newInterval;
        // 添加后面相离区间；
        while(i < intervals.length){
            res[index++] = intervals[i++];
        }
        // 如果插入成功，需要截取，最后一个没有更新；
        return Arrays.copyOf(res,index);
    }
}
