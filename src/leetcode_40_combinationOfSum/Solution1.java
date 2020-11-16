package leetcode_40_combinationOfSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//     题目： 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//            candidates 中的每个数字在每个组合中只能使用一次
//
//     思路：dfs
public class Solution1 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates,0,target,res,new LinkedList<Integer>());
        return res;
    }

    public void dfs(int[] nums, int start,int target,List<List<Integer>> res,LinkedList<Integer> path){

        if(target == 0)  {
            res.add(new LinkedList<Integer>(path));
            return;
        }

        for(int j = start; j < nums.length; j++) {

//            剪枝，如果减去 当前值 < 0,那么减去后面的数 结果必然 < 0;直接跳出循环；
            if (target - nums[start] < 0) {
                break;
            }
//            剪枝，同一层而且等于前面数字的，直接跳过；
            if(j > start && nums[j] == nums[j-1]){
                continue;
            }
//          如果不满足以上条件，将新一轮的数重新添加到临时链表中，并进入下一轮
            path.addLast(nums[j]);
            dfs(nums,j+1,target - nums[j],res,path);
            path.removeLast();
        }

    }
}
