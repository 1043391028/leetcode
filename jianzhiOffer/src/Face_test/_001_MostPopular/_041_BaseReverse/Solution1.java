package src.Face_test._001_MostPopular._041_BaseReverse;

//  题目： 禁止转换；
//  题目描述： 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数

//  思路： 注意负数；

public class Solution1 {
    public String solve (int M, int N) {
        // write code here
        StringBuilder sb = new StringBuilder();
        char[] ch = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char sign = '+';
        if(M < 0){
            M = -1*M;
            sign = '-';
        }
        while(M!=0){
            sb.append(String.valueOf(ch[M%N]));
            M /=N;
        }
        return sign == '-'? sb.append("-").reverse().toString():sb.reverse().toString();
    }
}
