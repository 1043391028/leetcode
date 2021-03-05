package lc_219_DumplicateEelement;

import java.util.HashSet;

// 思路二：HashSet

public class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet set = new HashSet();
        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
