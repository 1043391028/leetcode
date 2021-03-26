package leetcode002_DFS.lc_0306_IsAdditiveNum;

public class Solution2 {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if(len < 3) return false;
        return DFS(num,0,0,0,0);
    }
    public boolean DFS(String s,int start,int count,long sum,long pre){
        if(start == s.length() && count > 2) return true;
        for(int i = start;i< s.length();i++){
            long num = getNum(s,start,i);
            if(num == -1) break;
            if(count >= 2 && num > sum) break;
            if(count < 2 || num == sum) {
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
