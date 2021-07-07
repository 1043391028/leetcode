package src.Face_test._002_NC._037_merge;

//  题目： 合并区间；
//  描述： 给出一组区间，请合并所有重叠的区间。
//          请保证合并后的区间按区间起点升序排列。

//  思路一： 1.先将区间按照第一个元素从小到大排序（第一个元素相等的，按照第二个元素从大到小）
//          2. 遍历排序后的链表并合并；

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution1 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() <= 0) return intervals;
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1,Interval o2){
                return o1.start == o2.start?o2.end-o1.end:o1.start-o2.start;
            }
        });
        //  先将第一个元素加入到结果链表；
        res.add(intervals.get(0));
        for(int i = 1;i<intervals.size();i++){
            // 每次遍历将当前遍历元素的左右边界和结果链表中最后一个元素的边界相比（符合条件就合并）
            if(res.get(res.size()-1).end < intervals.get(i).start){
                res.add(intervals.get(i));
                continue;
            }else if(res.get(res.size()-1).end >= intervals.get(i).start){
                res.get(res.size()-1).end = Math.max(intervals.get(i).end,res.get(res.size()-1).end);
            }
        }
        return res;
    }
}
