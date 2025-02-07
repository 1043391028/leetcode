package lc_1663_getSmallestString;

import java.util.Arrays;

//  题目： 获得给定数值最小字符串；
//  描述： 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
//
//          字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
//
//          给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
//
//   注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
//
//        x 是 y 的一个前缀；
//        如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
//  示例 1：
//         输入：n = 3, k = 27
//         输出："aay"
//    解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
//
//   思路： 贪心；从后往前填充字符’z‘(尽量多的填充‘z’ 贪心);
public class Solution1 {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        // 将所有的字母填充为 'a' ;
        Arrays.fill(arr,'a');
        //
        // count_z 'z' 字符个数；first_z 第一个 z前面的字符；
        int count_z = (k-n)/25, first_z = (k-n)%25;
        // 判断，防止全是 z 的情况，越界；
        if(n - count_z-1 >= 0) arr[n - count_z - 1] += first_z;
        // 将 后面的字母改成 ‘z’
        for(int i = n-count_z;i<n;i++){
            arr[i] = 'z';
        }
        return String.valueOf(arr);
    }
}
