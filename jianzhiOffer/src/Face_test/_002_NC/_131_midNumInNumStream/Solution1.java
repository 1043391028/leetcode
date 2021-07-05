package src.Face_test._002_NC._131_midNumInNumStream;

//  题目： 随时找到数据流中的中位数；
//   描述：
//          有一个源源不断的吐出整数的数据流，假设你有足够的空间来保存吐出的数。请设计一个名叫MedianHolder的结构，
//           MedianHolder可以随时取得之前吐出所有数的中位数。
//  [要求]
//        1. 如果MedianHolder已经保存了吐出的N个数，那么将一个新数加入到MedianHolder的过程，其时间复杂度是O(logN)。
//        2. 取得已经吐出的N个数整体的中位数的过程，时间复杂度为O(1)
//
//     每行有一个整数opt表示操作类型
//      若opt=1，则接下来有一个整数N表示将N加入到结构中。
//      若opt=2，则表示询问当前所有数的中位数
//
//  示例1
//     输入：
//            [[1,5],[2],[1,3],[2],[1,6],[2],[1,7],[2]]
//   返回值：
//            [5,4,5,5.5]
//    说明：
//     第一次查询时结构内的数为：5
//     第二次查询时结构内的数为：3 5
//     第二次查询时结构内的数为：3 5 6
//     第二次查询时结构内的数为：3 5 6 7

//  思路一： 双堆；大顶堆+小顶堆；

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1,Integer o2){
//             return o2.compareTo(o1);
            return o2-o1;
        }
    }), minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1,Integer o2){
//             return o1.compareTo(o2);
            return o1-o2;
        }
    });

    public double[] flowmedian (int[][] operations) {
        // write code here
        List<Double> res = new ArrayList<>();
        for(int[] arr: operations){
            if(arr[0] == 1){
                addNum(arr[1]);
            }else{
                res.add(getNum());
            }
        }
        double[] ans = new double[res.size()];
        int index = 0;
//         for(Integer num : res){
//             ans[index++] = (double)num;
//         }
        for(int i = 0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    //  新加入的数在两个堆中轮流走一遍；
    // 这里先加入到大顶堆，所以大顶堆中数量 >= 小顶堆数量；
    public void addNum(Integer num){
        if(minHeap.size() == maxHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else{
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }
   //  两堆个数相等和不相等两种情况；
    // 但是要注意两者都为空的情况；
    public double getNum(){
        //  size == 0 一定要判断；
        if(maxHeap.size() == 0) return -1;
        if(maxHeap.size() == minHeap.size()){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }else return maxHeap.peek();
    }
}
