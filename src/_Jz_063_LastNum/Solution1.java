package _Jz_063_LastNum;

//  题目： 圆圈中最后的数字；(约瑟夫环)
//  描述： 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字
//         （删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
//
//        例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
//       则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
//
//  思路提醒：
//          从后往前推；

public class Solution1 {
    public int lastRemaining(int n, int m) {
        //  target ： 目的下标（最终剩下来的人下标）,最后一次下标为0（仅剩自己）; count: 代表人数，++count表示上一次圈里还剩的人数；
        //
        int target = 0,count = 1;
        // 每次循环都是在找目的数字在上一次大下标；
        while(count<n){
            target = (target+m)%(++count);
        }
        return target;
    }
}
