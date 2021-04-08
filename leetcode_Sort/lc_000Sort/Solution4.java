package lc_000Sort;

//  思路四： 堆排序；


public class Solution4 {
    public int[] MySort (int[] arr) {
        // write code here
        if(arr == null || arr.length < 2) return arr;
        int len = arr.length;
        for(int i = 0;i<len;i++){
            inity(arr,i);
        }
        swap(arr,0,--len);
        while(len>0){
            adjust(arr,0,len);
            swap(arr,0,--len);
        }
        return arr;
    }
    public void inity(int[] arr, int index){
        while(index>0 && arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    public void adjust(int[] arr,int index,int len){
        int left = index*2+1;
        while(left<len){
            int maxindex = left+1<len && arr[left] > arr[left+1]?left:left+1;
            maxindex = arr[maxindex] > arr[index]?maxindex:index;
            if(index == maxindex) break;
            swap(arr,index,maxindex);
            index = maxindex;
            left = index*2+1;
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
