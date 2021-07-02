package lc_0306_IsAdditiveNum;

//  思路二： 递归没回溯；
//        代码种解释；

public class Solution2 {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if(len < 3) return false;
        return DFS(num,0,0,0,0);
    }
    // start ： 每层开始下标（每层代表一个数）；count 目前遍历符合条件的数；
    // sum : 前两个数的和； pre ： 前一个数；
    public boolean DFS(String s,int start,int count,long sum,long pre){
        if(start == s.length() && count > 2) return true;
        for(int i = start;i< s.length();i++){
            long num = getNum(s,start,i);
            if(num == -1) break;
            if(count >= 2 && num > sum) break;
            if(count < 2 || num == sum) {
                // 如果在后免的递归层找到满足的数，直接一层一层向上 返回true，直到第一层直接返回true结果；
                //  如果后面的递归层不满足，直接向上一层递归，上一层继续遍历下一个字符；
                if(DFS(s,i+1,count+1,num+pre,num)) return true;
            }
        }
        return false;
    }

    public long getNum(String s,int start,int end){
        if(end > start && s.charAt(start) == '0') return -1;
        long res = 0;
        for(int i = start;i<=end;i++){
            res = res*10 + s.charAt(i) - '0' ;
        }
        return res;
    }
}
