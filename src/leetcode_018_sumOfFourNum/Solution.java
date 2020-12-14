package leetcode_018_sumOfFourNum;

//  题目： 四数之和；

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0;i < len -3;i++){
            if(i >0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1;j < len-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1, high = len-1;
                while(low < high){
                    int sum = nums[i] +nums[j] + nums[low] + nums[high];
                    if(sum > target) while(high > low && nums[high] == nums[--high]);
                    else if(sum < target) while(low < high && nums[low] == nums[++low]);
                    else{
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        res.add(list);
                        while(low < high && nums[low+1]==nums[low])      //确保nums[c] 改变了
                            low++;
                        while(low < high && nums[high-1]==nums[high])      //确保nums[d] 改变了
                            high--;
                        low++;
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
