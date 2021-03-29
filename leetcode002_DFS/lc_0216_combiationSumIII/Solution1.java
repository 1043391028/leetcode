package lc_0216_combiationSumIII;

import java.util.ArrayList;
import java.util.List;

//  题目： 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//  说明：
//       所有数字都是正整数。
//       解集不能包含重复的组合。 
// 示例 2:
//         输入: k = 3, n = 9
//         输出: [[1,2,6], [1,3,5], [2,3,4]]
//
//  思路： DFS + 回溯；

public class Solution1 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n>55 || n<0 || k>9) return res;
        boolean[] used = new boolean[10];
        DFS(k,n,1,new ArrayList<Integer>(),res);
        return res;
    }
    public void DFS(int count,int sum,int start,ArrayList<Integer> list,List<List<Integer>> res){
        if(count == 0){
            if(sum == 0){
                res.add(new ArrayList<>(list));
            }
            return ;
        }
        for(int i = start;i<=9;i++){
            list.add(i);
            DFS(count-1,sum-i,i+1,list,res);
            list.remove(list.size()-1);
        }
    }
}
