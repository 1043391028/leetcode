package lc_1502_canMakeArithmeticProgression;

// 题目描述： 是否能形成等差数列；
//
//         给你一个数字数组 arr 。
//
//          如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
//
//         如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
//

import java.util.Arrays;

public class Solution1 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int res = arr[0]-arr[1];
        for(int i = 1;i < len-1;i++){
            if(arr[i]-arr[i+1] != res) return false;
        }
        return true;
    }
}
