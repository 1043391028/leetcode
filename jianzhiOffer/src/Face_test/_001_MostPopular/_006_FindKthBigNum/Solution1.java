package Face_test._001_MostPopular._006_FindKthBigNum;

// 题目： 寻找数组中第K大元素；
//  描述： 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
//
//         给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
//  思路一：
//           快排；不用封装递归函数；
//                 思路二更快；
//
public class Solution1 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        int potation = location(a,0,n-1);
        if(potation == K-1) return a[potation];
        while(potation != K-1){
            if(potation > K-1) potation = location(a,0,potation-1);
            else potation = location(a,potation+1,n-1);
        }
        return a[potation];
    }
    // 找arr[left]本应该在的坐标location：左边都 >=arr[lacation], 右边都 <= arr[lacation];
    //     此思路是，在过程中将arr[left] 不停的在左右两边移动，最终到 laocation 位置停下；
    public int location(int[] arr,int left,int right){
        int flag = arr[left];
        while(left<right){
            while(left<right && arr[right] >= flag) right--;
            swap(arr,left,right);
            while(left<right && arr[left]<=flag) left++;
            swap(arr,left,right);
        }
        return left;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
