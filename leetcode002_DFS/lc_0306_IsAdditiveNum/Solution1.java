package leetcode002_DFS.lc_0306_IsAdditiveNum;

//  题目： 累加数；
//          累加数是一个字符串，组成它的数字可以形成累加序列。
//
//         一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
//
//         给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
//
//说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
//
// 示例 2:
//         输入: "199100199"
//         输出: true
//解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
//

import leetcode_018_sumOfFourNum.Solution;

import java.util.ArrayList;
//  思路一： 递归 + 回溯；（方法效率没有思路二高）
//     思路二： 递归（没回溯）；

public class Solution1 {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if(len < 3) return false;
        ArrayList<Long> res = new ArrayList<>();
        return DFS(num,0,res);
    }
    public boolean DFS(String s,int start,ArrayList<Long> res){
        if(start == s.length() && res.size() >= 3)return true;
        for(int i = start;i<s.length();i++){
            long num = getNum(s,start,i);
            if(num == -1) break;
            if(res.size() >= 2 && num > res.get(res.size()-1) + res.get(res.size()-2)) break;
            if(res.size() < 2 || num == res.get(res.size()-1) + res.get(res.size()-2)) {
                res.add(num);
                if(DFS(s,i+1,res)) return true;
                res.remove(res.size()-1);
            }
        }
        return false;
    }

    public int getNum(String s,int start,int end){
        if(end > start && s.charAt(start) == '0') return -1;
        int res = 0;
        for(int i = start;i<=end;i++){
            res = res*10 + s.charAt(i) - '0' ;
        }
        return res;
    }
}
