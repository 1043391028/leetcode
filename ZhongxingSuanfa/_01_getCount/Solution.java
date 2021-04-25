package _01_getCount;

import java.util.Arrays;

public class Solution {
    //private int[] arr1;
    //private int[] arr2;
    public int getCount(int[] array1,int[] array2){
        int res = 0;
        Arrays.sort(array2);
        int sum = array1[2];
        res -= array1[1];
        for(int i = array2.length-1;i>=0;i--){
            if(sum<=0) break;
            else{
                sum -= array2[i];
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[] {4,2,10};
        int[] arr2 = new int[] {1,2,3,4};
        Solution s = new Solution();
        int res = s.getCount(arr1,arr2);
        System.out.println(res);
    }
}
