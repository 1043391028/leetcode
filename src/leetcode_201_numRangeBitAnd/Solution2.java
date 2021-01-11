package leetcode_201_numRangeBitAnd;

//  思路二： 将最大数n和最小数m同时去掉低位，直到相等，此时值就是公共前缀的值；
//               将求得的公共前缀补0；

public class Solution2 {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0 || n == 0) return 0;
        int count = 0;
        while(m < n){
            m >>=1;
            n >>=1;
            count++;
        }
        return n<<count;
    }
}
