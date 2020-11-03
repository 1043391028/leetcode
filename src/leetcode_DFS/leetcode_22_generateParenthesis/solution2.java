package leetcode_DFS.leetcode_22_generateParenthesis;

//   思路2:  动态规划版本;
//           要确定 n 对 括号, 先确定 n- 1 对,
//          "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
//
//          其中 p + q = n-1，且 p q 均为非负整数。
//
//           事实上，当上述 p 从 0 取到 n-1，q 从 n-1 取到 0 后，所有情况就遍历完了

//          而且绝对不会有重复的情况;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class solution2 {
    public List<String> generateParenthesis(int n){
//     先创建一个链表,保存 n = 0 ~ n 之间每一个值对应的所有括号对;为了最后获得n,使用res.get(n) 即可;
        List<List<String>> res = new LinkedList<>();
        res.add(new LinkedList<String>(Arrays.asList(""))); // 把n == 0,添加进去;
        res.add(new LinkedList<String>(Arrays.asList("()")));// n ==  1,添加进去;
//        开始遍历 2 ~ n 的括号情况；
        for (int i = 2; i <= n; i++) {
            List<String> tmp = new LinkedList<>();
//            下面的for循环遍历只是某一值下（如2） 对应所有的括号情况；
            for (int j = 0; j < i; j++) {
//      '(' + 'res中所有已经保存的情况，从 0 开始到 n-1 ' + ')' + 'res中所有已经保存的情况，从i-1-0到i -1- (n-1)'
                List<String> str1 = res.get(j);
                List<String> str2 = res.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String str = "(" + s1 + ")" + s2;
                        tmp.add(str);
                    }
                }
            }
//            把每一次获得的结果添加到总链表中（2 ~ n）
            res.add(tmp);
        }
        return res.get(n);
    }

}
