package leetcode_sumOfKArray;

//  思路二: HashMap<Integer,Integer>; key值保存前缀和,value 保存该前缀和的个数;

import java.util.HashMap;

public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        if(nums == null|| nums.length == 0) return 0;
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int presum = 0 , count = 0;
        for(int num:nums){
            presum +=num;
            if(preSum.containsKey(presum-k)) count += preSum.get(presum-k);
            preSum.put(presum,preSum.getOrDefault(presum,0)+1);
        }
        return count;
    }
}
