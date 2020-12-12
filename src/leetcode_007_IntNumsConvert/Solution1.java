package leetcode_007_IntNumsConvert;

//   题目： 整数反转；
//   描述:  给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//          输入: 123
//          输出: 321
//   注意:
//          假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
//          请根据这个假设，如果反转后整数溢出那么就返回 0。
//
//   思路:  依次求出个位数num(%10),然后去掉最低为(除以10)
//          初始化 res = 0 依次将 res*10+ num; 直到 x=0;
//   注意:  越界问题;


public class Solution1 {
    public int reverse(int x) {
        int num = 0 , res = 0;
        while( x!= 0)
        {
            num = x%10;
            x = x/10;
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && num > 7)) return 0;
            if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && num == -9)) return 0;
            res = res*10 + num;
        }
        return res;
    }
}
