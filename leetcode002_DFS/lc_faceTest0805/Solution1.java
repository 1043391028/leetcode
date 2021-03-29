package lc_faceTest0805;

// 题目： 面试题 08.08. 有重复字符串的排列组合
//        有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
//示例1:
//        输入：S = "qqe"
//        输出：["eqq","qeq","qqe"]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        int len = S.length();
        if(S == null || len == 0) return null;
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[len];
        DFS(arr,new StringBuilder(),list,used);

        String[] res = new String[list.size()];
        int index = 0;
        for(String s:list){
            res[index++] = s;
        }
        return res;
    }
    public void DFS(char[] s,StringBuilder sb,List<String> res,boolean[] used){
        if(sb.length() == s.length){
            res.add(sb.toString());
            return ;
        }
        for(int i = 0;i<s.length;i++){
            if(!used[i]){
                if(i>0 && s[i] == s[i-1] && !used[i-1]) continue;
                sb.append(s[i]);
                used[i] = true;
                DFS(s,sb,res,used);
                used[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String  s = "qqe";
        Solution1 solution1 = new Solution1();
        String[] arr = solution1.permutation(s);
        for(String str: arr){
            System.out.println(str);
        }
    }
}
