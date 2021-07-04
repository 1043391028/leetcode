package src.Face_test._002_NC._111_maxNum;

//  题目： 最大数；
//  描述： 给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，返回值需要是string类型 否则可能会溢出
//   示例1
//     输入：
//        [30,1]
//   返回值：
//        "301"

//  思路一： 大顶堆；
//           主要是建立大顶堆将大的字符串放在堆顶，然后依次出队加入缓存串；

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    public String solve (int[] nums) {
        //
//         PriorityQueue<String> queue = new PriorityQueue<String>((s1,s2)->s2.compareTo(s1));
//         建立大顶堆（）
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(int num:nums){
            queue.add(String.valueOf(num));
        }
        if(queue.peek().equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
