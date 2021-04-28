package src.Face_test._001_MostPopular._040_TopKInStrings;

//  题目： 字符串中出现TopK次数问题；
//  描述:   给定一个字符串数组，再给定整数k，请返回出现次数前k名的字符串和对应的次数。
//          返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。
//          对于两个字符串，大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。
//          比如"ah1x"小于"ahb"，"231"<”32“
//          字符仅包含数字和字母
//  [要求]
//         如果字符串数组长度为N，时间复杂度请达到O(N \log K)O(NlogK)

//  思路一：大顶堆；（通过75%，不知原因，逻辑感觉正确）

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution1 {
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        int len = strings.length;
        //  HashMap 统计各个字符串的个数；
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:strings){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        // 大顶堆： 先按照字符串的个数，个数相等按照字符串字典序 从小到大优先级放 堆顶；
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) == map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1);
            }
        });
        //PriorityQueue<String> queue1 = new PriorityQueue<>((o1,o2)->map.get(o1) == map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1));
        for(String s : map.keySet()){
                queue.add(s);
        }
        String[][] res = new String[k][2];
        for(int i = 0;i<k;i++){
            res[i][0] = queue.peek();
            res[i][1] = String.valueOf(map.get(queue.poll()));
        }
        return res;
    }
}
