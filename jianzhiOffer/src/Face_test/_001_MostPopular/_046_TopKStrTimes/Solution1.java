package src.Face_test._001_MostPopular._046_TopKStrTimes;

//  题目： 字符串出现次数TOPK问题；
//  描述： 给定一个字符串数组，再给定整数k，请返回出现次数前k名的字符串和对应的次数。
//         返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。
//          对于两个字符串，大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。
//  比如  "ah1x"小于"ahb"，"231"<”32“
//        字符仅包含数字和字母
//
//  [要求]
//         如果字符串数组长度为N，时间复杂度请达到O(N \log K)O(NlogK)

//   方法一： 优先队列；（HashMap存字符串个数，优先队列按照个数排序，然后按照自然序；）


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution1 {
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        int len = strings.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:strings){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        //  优先队列；
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) == map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1);
            }
        });
        // 将字符串按照要求顺序加进队列，最后队列顶端尾 出现次数最多的字符串（次数相同按照字母自然序排列）
        for(String s : map.keySet()){
            queue.offer(s);
//              if(queue.size()<k){
//                  queue.offer(s);
//              }else{
//                  String heapString = queue.peek();
//                  if(map.get(s) > map.get(heapString) ||
//                     (map.get(s) == map.get(heapString) && heapString.compareTo(s)<0)){
//                      queue.poll();
//                      queue.offer(s);
//                  }

//              }
        }
        String[][] res = new String[k][2];
        for(int i = 0;i<k;i++){
            res[i][0] = queue.peek();
            res[i][1] = String.valueOf(map.get(queue.poll()));
        }
        return res;
    }
}
