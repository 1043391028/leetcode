package leetcode_78_allSubArray;

//       题目: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//             说明：解集不能包含重复的子集。

//        思路： dfs ；（复习此题和lettcode 题90，39，40，46，47 对比）

import java.util.*;

public class Solution1 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        LinkedList<Integer> deque = new LinkedList<>();
        dfs(nums,0,res,new LinkedList<Integer>());
        return res;
    }

    public void dfs(int[] nums, int deepth, List<List<Integer>> res, LinkedList<Integer> list){
//             此题不需要递归结束条件（下面循环条件暗含结束条件，下标 < nums.length），
//             每来一个就 新建一个字母链表 并加入结果链表；
               res.add(new LinkedList<>(list));
//             循环从 0 开始遍历，依次为 0，1，2...开头并直到数组最后一个元素；
               for(int j = deepth; j < nums.length; j++){
                   list.add(nums[j]);
                   dfs(nums,j+1,res,list);
//                   每次0. 1 .2...等开头的遍历结束后都要把上一个添加的去掉；如第一次循环结束后再出来就是空字符串
//                   接着重新从下标 2 开始遍历；
                   list.removeLast();
               }
    }
}
