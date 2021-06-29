package src.Face_test._001_MostPopular._049_MaxNum;

///   题目： 最大数；
//     描述： 给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，
//            返回值需要是string类型 否则可能会溢出
//     示例1
//            输入：
//                 [30,1]
//          返回值：
//                "301"

//   思路一：大顶堆；（将数组中数字变换成字符串按照反字典序加入大顶堆）；
//           以下方法没有通过案例[10,1]

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {

    public String solve (int[] nums) {
        // 大顶堆
        PriorityQueue<String> queue = new PriorityQueue<String>((s1,s2)->s2.compareTo(s1));
        //  小顶堆；
//         PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
        for(int num:nums){
            queue.add(String.valueOf(num));
        }
        // 如果队顶字符串为"0"那么直接输出"0";
        if(queue.peek().equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
