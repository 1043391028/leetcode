package leetcode_56_mergeDumplicateArray;

//      给出一个区间的集合，请合并所有重叠的区间。

import java.util.Arrays;

public class Solution1 {
    public int[][] merge(int[][] intervals){
        int[][] res = new int[intervals.length][2];
        if(intervals == null || intervals.length == 0) return res;

        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);  //lambda 表达式

        int index = -1; // 新建数组下标，为了把合并的区间有序保存到新数组
        for(int[] p : intervals){
//            如果数组为空或者上一个区间的右边界小于当前遍历区间的左边界，
//             说明没有重叠，都直接把新区间添加到新数组；
            if(index == -1 || res[index][1] < p[0]){
                res[++index] = p;
            }
//           否则就说明有重叠，因为已经排好序，需要合并，更新新区间和上一个保存区间右边界中较大的
//             （不用更新左边界，因为已经排好序，说明上一个区间左边界必定小于当前左边界）
            else {
                res[index][1] = Math.max(p[1],res[index][1]);
            }
        }
        return Arrays.copyOf(res,index+1);
    }

}
