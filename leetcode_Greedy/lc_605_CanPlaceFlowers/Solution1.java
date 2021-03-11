package lc_605_CanPlaceFlowers;

//  题目： 种花问题；
//  描述: 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
//
//给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。

//示例 1：
//       输入：flowerbed = [1,0,0,0,1], n = 1
//       输出：true
//
//   思路：

public class Solution1 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int i = 0;
        while(i < len){
            //  当前位置为 1 只能找下下个位置；
            if(flowerbed[i] == 1){
                i +=2;
            }else if(i == len-1 || flowerbed[i+1] == 0){
                // 当前位置为 0 ，两种情况满足（可以放花），
                //             1. 当前位置是最后一个元素，因为该位置是由为 1 的位置跳过来的，前面的元素必定是 0；
                //             2. 当前位置的下一个位置为 0（相邻都是 0）；
                n--;
                i +=2;
            }else{
                // 下一个位置为 1 的情况，只能跳到 i+3的位置，因为 i+1为 1 ，i+2 也不能放花；
                i +=3;
            }
        }
        return n <= 0;
    }
}
