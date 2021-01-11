package leetcode_201_numRangeBitAnd;

//  题目： 数字范围按位与；
//  描述： 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
//
//示例 1: 
//         输入: [5,7]
//         输出: 4
// 思路一： 位与（逐步去掉最大数后面最低位的1）
//         可以证明连续几个数字按位与是求所有数公共前缀，然后后面补0，的值；
//           所以，可以将最大的那个数二进制低位的 1 去掉（改成0），直到 <= 最小的数；停止；
//             此时 n 的值就是这些数的 公共前缀后面补0的值；

public class Solution1 {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0 || n == 0) return 0;
        while(m < n){
            n &= n-1;
        }
        return n;
    }
}
