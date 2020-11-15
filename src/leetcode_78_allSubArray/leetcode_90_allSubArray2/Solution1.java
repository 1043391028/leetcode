package leetcode_78_allSubArray.leetcode_90_allSubArray2;

//   题目： 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//          说明：解集不能包含重复的子集。
//   思路：dfs 和78题基本一样，只是多了一步去重（具体解释在题中）

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums,0,res,new LinkedList<>());
        return res;
    }

    public void dfs(int nums[], int start,List<List<Integer>> res, LinkedList<Integer> temp){
        res.add(new LinkedList(temp));

        for(int j = start; j < nums.length;j++){
//            这里是为了去重，j > start 说明 j 遍历的在同一层（即在同一个 for 循环中），
//            那么遍历过的重复的数就直接过掉；
            if (j > start && nums[j] == nums[j-1]) {
                continue;
            }
            temp.add(nums[j]);
            dfs(nums,start+1,res,temp);
            temp.removeLast();
        }
    }
}
