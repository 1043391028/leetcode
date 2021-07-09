package lc_000Sort._002quickSrot;

//  思路二： 快速排序；

public class Solution2 {
        // 主函数；
        public int[] MySort (int[] arr) {
            // write code here
            int len = arr.length;
            quickSort(arr,0,len-1);
            return arr;
        }
        // 快排函数；
        public void quickSort(int[] arr,int left,int right){
            if(left >= right) return ;
            int potation = location(arr,left,right);
            quickSort(arr,left,potation-1);
            quickSort(arr,potation+1,right);
        }
        // 找到对应元素位置函数；将对应元素放到本该属于它的位置；
        public int location(int[] arr,int left,int right){
            int flag = arr[left];
            while(left<right){
                while(left<right && arr[right]>=flag){
                    right--;
                }
                swap(arr,left,right);
                while(left<right && arr[left] <= flag){
                    left++;
                }
                swap(arr,left,right);
            }
            return left;
        }
        // 交换元素；
        public void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}
