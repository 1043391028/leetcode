package Face_test._001_MostPopular._006_FindKthBigNum;

//  思路二： 快排；
//            封装递归函数；

public class Solution2 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return find(a,0,n-1,K);
    }
    public int find(int[] arr,int left,int right,int K){
         // 定义 p 每次递归先保存返回的坐标，符合条件返回到上一层，不符合去两边找；
        //   直到找到坐标依次返回上层；
        int p = location(arr,left,right);
        if(p<K-1){
            return find(arr,p+1,right,K);
        }
        if(p>K-1){
            return find(arr,left,p-1,K);
        }
        return arr[p];
    }
    public int location(int[] arr,int left,int right){
        int flag = arr[left];
        while(left<right){
            while(left<right && arr[right]<=flag){
                right--;
            }
            swap(arr,left,right);
            while(left<right && arr[left] > flag){
                left++;
            }
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
