package lc_000Sort._002quickSrot;

//     快排;
//


public class QuickSort01 {
    public static void main(String[] args) {
        int[] arr = {3,7,6,5,8,2,1,9,2,3,7,4,6,7,9,2,2,3};
        System.out.println("排序前：");
        for (int num :arr) {
            System.out.print("  "+num);
        }
        QuickSort01 quickSort01 = new QuickSort01();
        quickSort01.quickSort(arr);
        System.out.println("排序后：");
        for (int num :arr) {
            System.out.print("  "+num);
        }
    }

    public void quickSort(int[] arr){
        if(arr == null || arr.length <= 1) return ;
        quickSortHelp(arr,0,arr.length-1);
    }

    public void quickSortHelp(int[] arr,int l,int r){
        if(l >= r) return ;
        int pos = getPos(arr,l,r);
        quickSortHelp(arr,l,pos-1);
        quickSortHelp(arr,pos+1,r);
    }

    public int getPos(int[] arr,int l, int r){
         int temp = arr[l];
         while(l<r){
             while(l<r && arr[r] >= temp){
                 r--;
             }
             swap(arr,l,r);
             while(l<r && arr[l] < temp){
                 l++;
             }
             swap(arr,l,r);
         }
         return l;
    }
    public void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
