package leetcode002_DFS.leetcode_22_generateParenthesis;

//    题目：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//     思路1： 递归加回溯 (这里如果使用字符串直接拼接,而不是使用 StringBuilder ,也可以不用回溯)


import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    LinkedList<String> list = new LinkedList<String>();
    public List<String> generateParenthesis(int n){

        if(n == 0) return list ;
        StringBuilder sb = new StringBuilder();
        dfs(sb, n,0, 0);
        return list;
    }
    void dfs(StringBuilder sb , int length,int left,int right){
        if(left == length && right == length) {
            list.push(sb.toString());
            return ;
        }
        if(left < right) return ;

        if(left < length) {
            dfs(sb.append('(') , length , left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }

        if(right < length){
            dfs(sb.append(')'),length,left,right+1);
//            递归出来一定要把自字符缓冲串 StringBuilder sb 中刚添加进去的字符删除，因为sb是可变的，不会创建新的字符,
//           这样就会不停添加
//           假如 n == 3,输出就是["((())))()))()))(()))()","((())))()))()))(())","((())))()))()","((())))())","((()))"]
            sb.deleteCharAt(sb.length()-1);
        }

    }

}
