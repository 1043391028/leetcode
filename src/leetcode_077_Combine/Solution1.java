package leetcode_077_Combine;

//   题目: 组合;
//   描述: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//   示例:
//         输入: n = 4, k = 2
//         输出:
//               [
//                 [2,4],
//                 [3,4],
//                 [2,3],
//                 [1,2],
//                 [1,3],
//                 [1,4],
//               ]
//
//      思路一: 正常递归回溯; + 剪枝(可选)
//      思路二: 递归回溯; (遍历每个数字时可以 选择或不选择); +(可以剪枝和思路一一样,限制 i 上边界)

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, n,1, k,new ArrayList<>());
        return res;
    }
    public void backTrack(List<List<Integer>> res, int n,int begin,int k,ArrayList<Integer> temp){
        if(k == 0){
            res.add(new ArrayList<>(temp));
            return ;
        }

        for(int i = begin;i <= n;i++){
            temp.add(i);
            backTrack(res,n,i+1,k-1,temp);
            temp.remove(temp.size()-1);
        }
    }
    // 剪枝后代码; 即限制 i 的选择上界 : i <= n - (k-(temp.size())+1);
    //   public List<List<Integer>> combine(int n, int k) {
    //          List<List<Integer>> res = new ArrayList<>();
    //          backTrack(res, n,1, k,new ArrayList<>());
    //          return res;
    //    }
    //    public void backTrack(List<List<Integer>> res, int n,int begin,int k,ArrayList<Integer> temp){
    //          if(temp.size() == k){
    //              res.add(new ArrayList<>(temp));
    //              return ;
    //          }
    //          // for(int i = begin;i <= n;i++) 未剪枝结果;
    //          for(int i = begin; i <= n-(k-temp.size())+1; i++){
    //             temp.add(i);
    //             backTrack(res,n,i+1,k,temp);
    //             temp.remove(temp.size()-1);
    //          }
    //    }
}

