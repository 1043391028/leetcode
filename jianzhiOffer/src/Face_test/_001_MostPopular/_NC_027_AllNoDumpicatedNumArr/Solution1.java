package src.Face_test._001_MostPopular._NC_027_AllNoDumpicatedNumArr;

//  题目： 集合中所有子集；
///    描述：
//           现在有一个没有重复元素的整数集合S，求S的所有子集
//     注意：
//          你给出的子集中的元素必须按升序排列
//          给出的解集中不能出现重复的元素
//    示例1
//          输入：
//              [1,2,3]

//          返回值：
//             [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]

//   思路： DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // 必须排序；
        Arrays.sort(S);
        DFS(S,0,new ArrayList<>());
        return res;
    }
    //  index 为了递归不重复；每层从index开始一直到最后一个元素（遍历完），避免了再把前面元素遍历；
    public void DFS(int[] s,int index,ArrayList<Integer> list){
        // 相当于每次进循环就把上次循环的结果加入结果队列；
        res.add(new ArrayList<>(list));
        for(int i =index;i<s.length;i++){
            list.add(s[i]);
            DFS(s,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
