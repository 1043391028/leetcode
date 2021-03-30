package lc_FaceTest_0805_permutation;

// 题目：面试题 08.07. 无重复字符串的排列组合

//  描述: 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
//
//示例1:
//       输入：S = "qwe"
//       输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
//

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        boolean[] used = new boolean[S.length()];
        DFS(S,used,new StringBuilder(),list);
        String[] arr = new String[list.size()];
        int index = 0;
        for(String s : list){
            arr[index++] = s;
        }
        return arr;
    }
    public void DFS(String s, boolean[] used, StringBuilder sb, List<String> list){
        if(sb.length() == s.length()){
            list.add(sb.toString());
        }
        for(int i=0;i<s.length();i++){
            if(!used[i]){
                used[i] = true;
                sb.append(s.charAt(i));
                DFS(s,used,sb,list);
                used[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
