package leetcode_39_combinationSum;

//      题目：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//           candidates 中的数字可以无限制重复被选取。

//           说明：
//                所有数字（包括 target）都是正整数。
//                解集不能包含重复的组合。

//       思路： 递归 + 回溯；

import java.util.*;

public class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int lenth = candidates.length;
        List<List<Integer>> list = new ArrayList<>();
        if(lenth == 0 || candidates == null) return list;
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(candidates,0,lenth,target,path,list);
        return list;
    }

    void dfs(int[] array,int index,int lenth,int target,Deque<Integer> path,List<List<Integer>> list){
        if(target == 0){
            list.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < lenth; i++){
            if(target - array[i] < 0){
                break;
            }
            path.addLast(array[i]);
            dfs(array,i,lenth,target - array[i],path,list);
            path.removeLast();
        }
    }
}
