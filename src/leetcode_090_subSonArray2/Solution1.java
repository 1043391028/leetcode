package leetcode_090_subSonArray2;

//  题目: 子集II;
//  描述:  给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//  说明：解集不能包含重复的子集。
//
//  示例:
//         输入: [1,2,2]
//         输出:
//               [
//                 [2],
//                 [1],
//                 [1,2,2],
//                 [2,2],
//                 [1,2],
//                 []
//               ]
//
//    思路:  dfs(不剪枝,但是要排除重复的结果组)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null|| nums.length == 0) return null;
        // 必须先把数组排序才能进行后面的重复情况排除;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,0,nums.length,new ArrayList<Integer>(),res);
        return res;
    }
    public void dfs(int[] nums,int start,int n,List<Integer> path, List<List<Integer>> res){
        //  此题是要所有情况,所以每进来一次就把上层添加完的元素添加进结果数组 res 中;
        res.add(new ArrayList<Integer>(path));
        if(start == n) return ;
        for(int i = start;i < n;i++){
            // 排除重复情况,i>start 保证是同一层才排除;
            if(i>start && nums[i] == nums[i-1]) continue;
            // 每遍历之前先把当前层数字加进临时数组 path 中;
            path.add(nums[i]);
            // 进入下一层;
            dfs(nums,i+1,n,path,res);
            // 出来返回当前层,需要把选择的删除,重新选择(尝试另外的情况)
            path.remove(path.size()-1);
        }
    }
}
