package leetcode_347_topKFrequentNum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//   思路二: 桶排序法;
//           1. 用 HashMap 统计每个数字对应的个数;
//           2. 建立一个链表数组, 对于不同频率的数,用出现次数当下标,每个数组元素(链表)保存相同次数的数;
//           3. 新建结果链表res, 按照从后往前顺序遍历数组,依次将key添加到结果链表中,直到 res.size()=k;
public class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k){
        // 新建 HashMap 保存数组中每个数字对赢得个数;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
         // 2. 建立一个链表数组, 对于不同频率的数,用出现次数当下标,每个数组元素(链表)保存相同次数的数;
        List<Integer>[] list = new ArrayList[nums.length+1];
        for(int key:map.keySet()){
            if(list[map.get(key)]==null){
                list[map.get(key)] = new ArrayList<>();
            }
            list[map.get(key)].add(key);
        }
        // 3. 新建结果链表res, 按照从后往前顺序遍历数组,依次将key添加到结果链表中,直到 res.size()=k;
        List<Integer> res = new ArrayList<>();
        for(int i = list.length-1;i>=0 && res.size()<k;i--){
            if(list[i] != null){
                res.addAll(list[i]);
            }
        }
        return res;
        // 返回类型是数组的话,下面语句;
        // int[] res1 = res.stream().mapToInt(Integer::valueOf).toArray();
        // return res1;
    }
}
