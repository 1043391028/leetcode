package leetcode_42_trapWater;

//     题目：   给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

//     思路1： 按行求；
//             整个思路就是，求第 i 层的水，遍历每个位置，如果当前的高度小于 i，并且两边有高度大于等于 i 的，
//              说明这个地方一定有水，水就可以加 11。
//             如果求高度为 i 的水，首先用一个变量 temp 保存当前累积的水，初始化为 00。从左到右遍历墙的高度，
//               遇到高度大于等于 i 的时候，开始更新 temp。更新原则是遇到高度小于 i 的就把 temp 加 11，
//               遇到高度大于等于 i 的，就把 temp 加到最终的答案 ans 里，并且 temp 置零，然后继续循环。
//

public class Solution1 {
    public int trap(int[] height){
        if(height == null || height.length == 0) return 0;
        int maxHigh = getMax(height);
        int sum = 0;

       for(int i = 1; i <= maxHigh;i++){
           int temp = 0;
           boolean isTrue = false;
           for(int j = 0 ; j < height.length;j++) {
               if (isTrue && height[i] < i) {
                   temp++;
               }

               if(height[j] >= i){
                   sum = sum + temp;
                   temp = 0;
                   isTrue = true;
               }
           }
       }
       return sum;
    }

    int getMax(int[] array){
        int max = 0;
        for(int i = 0;i < array.length;i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }
}
