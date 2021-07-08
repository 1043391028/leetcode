package src.Face_test._002_NC._026_differentkuoHao;

//  题目： 生成不同括号种类个数；
//   描述： 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
//
//  例如，给出n=3，解集为：
//          "((()))", "(()())", "(())()", "()()()", "()(())",
//
// 思路一： DFS；

import java.util.ArrayList;

public class Solution1 {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> generateParenthesis (int n) {
        dfs(0,0,n,new StringBuilder());
        return res;
    }
    public void dfs(int left,int right,int len,StringBuilder sb){
        if(right == len){
            res.add(sb.toString());
            return;
        }
        if(left < len){
            sb.append("(");
            dfs(left+1,right,len,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right < left){
            sb.append(")");
            dfs(left,right+1,len,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
