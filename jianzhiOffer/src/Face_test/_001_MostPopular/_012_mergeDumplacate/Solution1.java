package Face_test._001_MostPopular._012_mergeDumplacate;

//  题目： 合并区间；
//  描述:  给出一组区间，请合并所有重叠的区间。
//         请保证合并后的区间按区间起点升序排列。

///  思路一： 排序；
//           1.按照第一个元素从小到大，第二个元素从大到小对链表元素排序；
//           2.然后先将第一个元素加入到结果链表res，从第二个元素开始遍历排序后的链表
//               遍历元素的第一个元素在res最后一个元素区间内，则更更新res链表的区间；
//                  不在区间内，则将当前元素添加的res链表中；

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
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval o1,Interval o2){
                return o1.start == o2.start? o2.end-o1.end:o1.start-o2.start;
            }
        });
      // Collections.sort(intervals,(o1,o2)->o1.start == o2.start?o2.end-o1.end:o1.start-o2.start);
        ArrayList<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() < 2) return intervals;
        res.add(intervals.get(0));
        for(int i = 1;i<intervals.size();i++){
            if(intervals.get(i).start<=res.get(res.size()-1).end){
                res.get(res.size()-1).end = Math.max(intervals.get(i).end,res.get(res.size()-1).end);
            }else{
                res.add(intervals.get(i));
            }
        }
        return res;
    }
}
