package leetcode_029_Divide;

//  题目： 两数相除；
//  描述： 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
//         返回被除数 dividend 除以除数 divisor 得到的商。
//
//        整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
// 示例 1:
//         输入: dividend = 10, divisor = 3
//         输出: 3
//   解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
//   被除数和除数均为 32 位有符号整数。   除数不为 0。
//   假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
//      本题中，如果除法结果溢出，则返回 231 − 1。
//
// 思路一：60/8 ;
//         60 = (8*2)*2 + (8*2) + 8   == 4（2^2次）+2（2^1次）+1（2^0次） =7;(乘以 i 次2,代表需要 2^i 个除数；)
//

public class Solution1 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            else return -dividend;
        }
        int sign = 1;
        if((dividend>0 &&  divisor<0) || (dividend < 0 && divisor >0)){
            sign = -1;
        }
        int p = dividend>0? -dividend:dividend, n = divisor>0? -divisor:divisor;
        int res = divideHelp(p,n);
        return res == Integer.MIN_VALUE? Integer.MIN_VALUE:res*sign ;
    }

    public int divideHelp(long dividend,long divisor){
        if(dividend > divisor) return 0;
        // 初始化两个参数 m , n 分别代替dividend 和 divisor
        // 因为下面算法需要不停的使用变换 divisor的倍数值，但是递归还会用dividend 和 divisor,所以不能更改；
        long m = dividend , n = divisor;
        // 计数值 count 每次while循环多少次；
        int count = 1;
        while(m <= (n+n)){
            count *=2;
            n *=2;
        }
        return count+divideHelp(m-n,divisor);
    }

}
