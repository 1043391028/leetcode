package src.Face_test._001_MostPopular._020_CombinationSumInArr;

// 题目： 加起来和为目标的数的集合；
//  描述：
//       给出一组候选数\ C C 和一个目标数\ T T，找出候选数中起来和等于\ T T 的所有组合。
//        中的每个数字在一个组合中只能使用一次。
//           结果中不能包含重复的组合
//        组合之间的排序按照索引从小到大依次比较，小的排在前面，如果索引相同的情况下数值相同，则比较下一个索引。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  思路：
//          dfs(注意排序和重复元素)

public class Solution1 {
    // 定义used数组，标记元素是否遍历过；避免重复；
    private boolean[] used;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        used = new boolean[num.length];
        // 先由小到大排序数组；
        Arrays.sort(num);
        dfs(num,res,0,list,target);
        return res;
    }
    public void dfs(int[] num,ArrayList<ArrayList<Integer>> res,int index,ArrayList<Integer> list,int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
        }
        for(int i = index;i<num.length;i++){
            if(target - num[i] < 0){
                break;
            }
            if(i>0 && !used[i-1] && num[i] == num[i-1]) continue;
            used[i] = true;
            list.add(num[i]);
            dfs(num,res,i+1,list,target-num[i]);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
