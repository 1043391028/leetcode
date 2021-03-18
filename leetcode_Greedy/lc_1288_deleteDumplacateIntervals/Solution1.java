package lc_1288_deleteDumplacateIntervals;

// 题目： 删除被覆盖区间；
//  描述：给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
//
//         只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
//
//          在完成所有删除操作后，请你返回列表中剩余区间的数目。
//示例：
//     输入：intervals = [[1,4],[3,6],[2,8]]
//     输出：2
// 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
//
//  思路： 将数组按照 第一个元素从小到大，第二个元素从大到小排序；
//          依次遍历数组，将第一个数的右边界作为参照；如果下一个区间的右边界 <= 当前边界，则可以覆盖(结果) ans++（左边界是从小到大排列的）；
//              如果下一个区间的右边界 > 当前边界，更新右边界为当前边界，（继续循环）；

import java.util.Arrays;

public class Solution1 {
    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        // 将数组排序（按照第一个元素从小到大，第二个元素从大到小；）
        Arrays.sort(intervals,(first, second)->(first[0] == second[0]?second[1]-first[1]:first[0]-second[0]));
        int ans = 0;
        int temp = intervals[0][1];
        for(int i=1;i < len;i++){
            if(intervals[i][1] <= temp){
                ans++;
                continue;
            }else{
                temp = intervals[i][1];
            }
        }
        return len-ans;
    }
}
