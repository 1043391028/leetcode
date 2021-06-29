package src.Face_test._001_MostPopular._048_AllArrOfDumplicatedArray;

//  题目： 有重复数字的所有排列；
//  描述： 给出一组可能包含重复项的数字，返回该组数字的所有排列。
//   示例1
//         输入：
//               [1,1,2]
//       返回值：
//              [[1,1,2],[1,2,1],[2,1,1]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//    思路： DFS + 回溯；

public class Solution1 {
    Boolean[] visited;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(num == null || num.length == 0) return res;
        Arrays.sort(num);
        visited = new Boolean[num.length];
        List<Integer> list = new ArrayList<>();
        DFS(num,res,list);
        return res;
    }
    public void DFS(int[] num,ArrayList<ArrayList<Integer>> res,List<Integer> list){
        if(list.size() == num.length){
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i = 0;i<num.length;i++){
            if(i>0 && num[i] == num[i-1] && !visited[i-1]) continue;
            if(visited[i]) continue;
            list.add(num[i]);
            visited[i] = true;
            DFS(num,res,list);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
