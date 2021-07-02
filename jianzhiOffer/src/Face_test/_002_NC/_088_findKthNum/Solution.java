package src.Face_test._002_NC._088_findKthNum;

// 题目： 寻找第K大数；
// 描述： 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
//
//       给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。
//示例1
//       输入：
//            [1,3,5,2,2],5,3
//     返回值：
//             2

//    思路1：快排思路（只找位置）；

public class Solution {
    public int findKth(int[] a, int n, int K) {
        //  找到数组左边数（该在）的位置；（从大到小顺序）
        int location = find(a,0,n-1);
//       如果不在第 K 位，继续在两边的其中一边找;直到找到第K位置的数；
        while(location != K-1){
            // location>k-1 说明第K大的数在该位置的数的左边；
            if(location > K-1) location = find(a,0,location-1);
            // 反之在右边；
            else location = find(a,location+1,n-1);
        }
        return a[location];
    }
    // 找坐标函数（按照从大到小的顺序）；每轮循环过后arr[start]这个数就在他本该在的位置；
    //      返回的位置下标也就是改数最后的位置；
    public int find(int[] arr,int start,int end){
        int sign = arr[start];
        while(start<end){
            while(start<end && arr[end]<=sign) end--;
            swap(arr,start,end);
            while(start<end && arr[start] >sign) start++;
            swap(arr,start,end);
        }
        return start;
    }
    //  交换位置函数；
    public void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
