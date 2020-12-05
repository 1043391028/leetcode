package leetcode_347_topKFrequentNum;

//  题目: 前 k 个高频元素;
//  描述: 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//示例 1:
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]
//  提示：
//        你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//        你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
//        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
//        你可以按任意顺序返回答案。
//
//  思路一: HashMap + 最小堆
//           时间复杂度: o(nlogk); n是遍历n个数,添加到最小堆是logk;
//           空间复杂度: o(n);Hashmap最大是n(每个数各有一次);

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {
    public int[] topKFrequent(int[] nums, int k){
        // 建立HashMap; 保存数组nums中每个数字对应出现的次数;
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 建立最小堆,根据键对应的值(数对应出现的次数)来排序;最小的放在最顶端,遍历完数组,保存k个即可;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(map.get(o1)-map.get(o2)));
        for(int key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else if(map.get(key)>map.get(pq.peek())){
                pq.poll();
                pq.add(key);
            }
        }
        // 新建结果数组,遍历最小堆,保存最小堆里面的key到数组;
        int[] res = new int[k] ;
        int index = 0;
        while(!pq.isEmpty()){
            res[index++] = pq.poll();
        }
        return res;
    }
}
