package src.Face_test._002_NC._042_AllPermunationInDumplicatedNum;

//  题目： 有重复数字的全排列；
//   描述： 给出一组可能包含重复项的数字，返回该组数字的所有排列。
//   示例1
//         输入：
//                [1,1,2]
//       返回值：
//               [[1,1,2],[1,2,1],[2,1,1]]

//     思路一： DFS+剪枝；

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution1 {
    boolean[] visited;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(num == null || num.length == 0) return res;
        // 排序+visit[]标记：为了剪枝
        Arrays.sort(num);
        visited = new boolean[num.length];
        LinkedList<Integer> list = new LinkedList<>();
        DFS(num,res,list);
        return res;
    }
    public void DFS(int[] num,ArrayList<ArrayList<Integer>> res,LinkedList<Integer> list){
        if(list.size() == num.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<num.length;i++){
            if(visited[i] || i>0 && num[i] == num[i-1] && !visited[i-1]) continue;
            
            visited[i] = true;
            list.add(num[i]);

            DFS(num,res,list);

            list.removeLast();
            visited[i] = false;
        }
    }
}
