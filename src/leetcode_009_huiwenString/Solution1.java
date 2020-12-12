package leetcode_009_huiwenString;

//  题目： 回文数；
//  描述:  判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//示例 1:
//          输入: 121
//          输出: true
//  进阶:
//         你能不将整数转为字符串来解决这个问题吗？

public class Solution1 {
    public boolean isPalindrome(int x) {
        // 这里没有明写排除负数情况,实际上利用 最后判断语句 return res = x; 排除了;
        //  如果为负数,直接返回 false;
        // if( x < 0) return false;
        int res = 0 , temp = x;
        // 注意条件，一定是 temp > 0 否则负数通过不了；
        while(temp > 0){
            int num = temp%10;
            res = res*10+num;
            temp /= 10;
        }
        return res == x ;
    }
}
