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
        //swap(arr,0,--len);
        while(len>0){
            swap(arr,0,--len);
            adjust(arr,0,len);
          //  swap(arr,0,--len);
        }
        return arr;
    }
    public void inity(int[] arr, int index){
        while(index>0 && arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    // 调整函数，每次将最大的数放到最后一个位置，最后一个位置的数放到顶部（大顶堆）
    //     需要将这个数依次和下面的数对比，将最大的数放到最顶部；
    public void adjust(int[] arr,int index,int len){
        // 先确定第一个位置的左子结点
        int left = index*2+1;
        while(left<len){
            //  下面的判断注意：
//                         一定要先确定 left+1 < len ,不满足就直接 = left;
            //                同时满足 left+1<len && arr[left]<arr[left+1] = left+1;
            int maxindex = left+1<len && arr[left] < arr[left+1]?left+1:left;
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
