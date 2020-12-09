package leetcode_015_sumOfThreeNumber;

//    题目： 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
//           请你找出所有满足条件且不重复的三元组。
//
//           注意：答案中不可以包含重复的三元组。
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List <List<Integer>> result = new ArrayList();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0 ; i < len - 2;i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = len - 1;

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[l],nums[r])));
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if(sum < 0) l++;
                 else if(sum > 0) r--;
            }

        }
        return result;
    }

}
