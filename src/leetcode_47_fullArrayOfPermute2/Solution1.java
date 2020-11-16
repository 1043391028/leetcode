package leetcode_47_fullArrayOfPermute2;

//   题目： 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//          输入：nums = [1,1,2]
//          输出： [[1,1,2],[1,2,1],[2,1,1]]

//      dfs + 剪枝思想（即把重复的元素情况去掉）

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,nums.length,used,res,new LinkedList<>());
        return res;
    }

    public void dfs(int[] nums, int depth,int length,boolean[] used,List<List<Integer>> res,LinkedList<Integer> path){
//      开始判断如果遍历深度为数组长度，就说明以某个元素开头的某一次深度遍历已经遍历一遍，
//       直接将临时链表添加进总结果链表；
        if(depth == length) {
            res.add(new LinkedList<>(path));
            return;
        }
//       循环开始，从下标为 0 的元素开始，把所有 0 元素开头的情况遍历一遍，继续遍历下标为 1 的元素开头的；
         for(int i = 0; i < nums.length;i++){

            if(used[i]) continue;
//        剪枝的重点，！used[i-1] 说明前面遍历过但是又回溯回来了，而nums[i] == nums[i-1] 保证前后两个元素相等，
//           这就体现了为什么剪枝的前提就是数组提前排序，未排序无法确定前后就是重复的元素，也就无法剪枝；
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
//          把档前元素添加进临时链表，并开始下一轮循环；
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,depth+1,length,used,res,path);
//            回溯到值前状态；因为此题是数组元素 所有数字可以任意排列，所以需要重新回来遍历；
            used[i] = false;
            path.removeLast();
        }
    }

}
