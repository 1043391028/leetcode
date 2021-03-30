package lc_FaceTest_0804_subSet;

// 题目： 幂级；
//  描述： 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
//
//  说明：解集不能包含重复的子集。
//
//  示例:
//        输入： nums = [1,2,3]
//        输出：
//       [
//         [3],
//         [1],
//         [2],
//         [1,2,3],
//         [1,3],
//         [2,3],
//         [1,2],
//         []
//       ]
//

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(nums,0,res,new ArrayList<Integer>());
        return res;
    }
    public void DFS(int[] nums,int start,List<List<Integer>> res,List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = start;i<nums.length;i++){
            list.add(nums[i]);
            // 注意： start 是 i+1 不是 start+1;
            DFS(nums,i+1,res,list);
            list.remove(list.size()-1);
        }
    }
}
