package FaceTest._003_cutRope;

//  题目： 剪绳子II；
//  描述： 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
//         每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
//           例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
//     答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//  思路一： 贪心；
//           推算可知，绳子优先剪为长度为 3 时乘积最大；

public class Solution1 {
    public int cuttingRope(int n) {
        // n < 4 时 应该为 n-1：  3：（2，1）； 2：（1，1）；
        if(n < 4) return n-1;
        // 这里注意结果定义为 long 防止越界；最后要转换；
        long res = 1;
        // n > 4时分割绳子（无限分割为 3）；
        // 实际上也就是把 n%3 == 1,0的结果另外计算了；
        while(n>4){
            res = (res*3)%1000000007;
            n -=3;
        }
        // 最后 n 的值： 4，3，2，1 分割结果乘积最大为4，3，2，1；
        return (int)(res*n%1000000007);
    }
}
//
//  库函数；
// class Solution {
//    public int cuttingRope(int n) {
//        if(n <= 3) return n - 1;
//        int a = n / 3, b = n % 3;
//        if(b == 0) return (int)Math.pow(3, a);
//        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
//        return (int)Math.pow(3, a) * 2;
//    }
//}
//
