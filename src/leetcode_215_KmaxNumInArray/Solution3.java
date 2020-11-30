package leetcode_215_KmaxNumInArray;

//   思路三：快排思想

import java.util.PriorityQueue;
import java.util.Random;

public class Solution3 {
//    产生随机数；
    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
          int len = nums.length;
          int targrt = len - k;
          int left = 0;
          int right = len-1;
          while(true){
              int index = partition(nums,left,right);
              if(index == k) return nums[index];
              else if(index > k){
                  left = index-1;
              }else right = index+1;
          }
    }

//    划分函数（经过划分，返回当前随机值应该所处的位置，左边都是小于，右边使大于等于，的元素）
    public int partition(int[] array,int start,int end){
          if(end > start){
              int randomIndex = start + 1 + random.nextInt(end-start);
              swap(array,start,randomIndex);
          }

          int pivot = array[start];
          int j = start;
          for(int i=j+1;i <= end;i++){
              if(array[i] < pivot){
                  j++;
                  swap(array,j,i);
              }
          }
          swap(array,start,j);
          return j;
    }

//    元素交换函数
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
