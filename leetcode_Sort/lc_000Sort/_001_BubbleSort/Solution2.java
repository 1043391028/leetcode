package lc_000Sort._001_BubbleSort;

//   改进版冒泡排序；


public class Solution2 {
    public static void main(String[] args) {
        int[] arr = {2,4,7,5,8,3,6,8,9,3,5,7};
        int len = arr.length;
        System.out.println("排序前顺序：");
        for(int num:arr){
            System.out.print("   "+num);
        }
        System.out.println();
        sort(arr,len);
        System.out.println("排序后顺序：");
        for(int num:arr){
            System.out.print("   "+num);
        }
    }

    static void sort(int[] arr,int len) {
        int l = 0, r = len-1;
        while(l<r){
            for(int i = l;i<r;i++){
                if(arr[i] > arr[i+1])
                    swap(arr,i,i+1);
            }
            r--;
            for(int i = r;i>l;i--){
                if(arr[i] < arr[i-1])
                    swap(arr,i,i-1);
            }
            l++;
        }
    }

    static void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
