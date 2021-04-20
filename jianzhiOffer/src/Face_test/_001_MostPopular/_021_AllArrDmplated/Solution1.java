package src.Face_test._001_MostPopular._021_AllArrDmplated;

// 题目： 不重复数字的所有排列；
//  描述：
//         给出一组数字，返回该组数字的所有排列
//  例如：
//        [1,2,3]的所有排列如下
//         [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
//（ 以数字在数组中的位置靠前为优先级，按字典序排列输出。）

// 思路： DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    private boolean[] visited;
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);
        int len = num.length;
        visited =  new boolean[len];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(num,res,list);
        return res;
    }
    public void dfs(int[] num,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list){
        if(list.size() == num.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0;i<num.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            list.add(num[i]);
            dfs(num,res,list);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
