package lc_000Sort;

//  思路三： 归并排序；

public class Solution3 {
    // 主函数；
    public int[] MySort (int[] arr) {
        // write code here
        int len = arr.length;
        mergeSort(arr,0,len-1);
        return arr;
    }
    // 分治排序：所有的过程都是在原数组中操作，分 和 合  的过程不需要返回数组；
    //          每递归进入 分 的函数中，就相当于在 操作下标 left~right 中的元素，合并的时候，
    //           新建一个大小为（right-left+1）的数组，将下标为left和right 之间的元素排好；
    //  分；
    public void mergeSort(int[] arr,int left,int right){
        if(left == right) return ;
        // 中间边界；
        int mid = left+(right-left)/2;
        // 中间左边（包括mid）
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    //  合；(这里的合并包括右边界)
    public void merge(int[] arr,int left,int mid,int right){
        // 新建合并数组res，长度为左右边界中间的个数（包括左右边界）
        int[] res = new int[right-left+1];
        int i = left, j = mid+1,index = 0;
        // 一次选择两数组选择较小元素放res数组前面；
        while(i <= mid && j <= right){
            res[index++] = arr[i] > arr[j]?arr[j++]:arr[i++];
        }
        // 哪一个未选择完，直接依次加入结果中
        while(i<=mid) res[index++] = arr[i++];
        while(j<=right) res[index++] = arr[j++];
        // 遍历结果数组，添加到原数组arr对应位置；
        for(int k = 0;k<res.length;k++){
            arr[k+left] = res[k];
        }
    }
}
