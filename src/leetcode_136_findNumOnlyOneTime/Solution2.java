package leetcode_136_findNumOnlyOneTime;

//    思路二：HashMap;  map.getOrDefult(key,value);

import java.util.HashMap;

public class Solution2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)) map.put(num,map.get(num)+1);
            else map.put(num,1);
        }

        for(int i = 0;i< nums.length;i++){
            if(map.get(nums[i]) == 1) return nums[i];
        }
        return 0;
    }
}
