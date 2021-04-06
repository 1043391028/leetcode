package lc_000Sort;

//  题目： 排序；
//  描述： 给定一个数组，请你编写一个函数，返回该数组排序后的形式。

//  思路一： 冒泡排序；
//          O（n） n^2;

public class Solution1 {
    public int[] MySort (int[] arr) {
        // write code here
        int len = arr.length;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // 标准模式，实际上应该为下面这样；
        // for(int i=0;i<arr.length-1;i++){
        //      for(int j=0;j<arr.length-i-1;j++){
        //          if(arr[j]>arr[j+1]){
        //              swap(arr,j,j+1);// 交换元素；
        //          }
        //      }
        //  }
        return arr;
    }
}
