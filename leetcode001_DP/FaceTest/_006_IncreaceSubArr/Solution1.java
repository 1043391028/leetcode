package FaceTest._006_IncreaceSubArr;

//  题目： 最长递增子序列；
//  描述： 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）

import java.util.Arrays;

public class Solution1 {
        /**
         * retrun the longest increasing subsequence
         * @param arr int整型一维数组 the array
         * @return int整型一维数组
         */
        public int[] LIS (int[] arr) {
            // write code here
            if(arr == null || arr.length == 0)return new int[0];
            int len = arr.length;
            int[] end = new int[len];
            int[] dp = new int[len];
            // index 表示递增数组的长度（不是下标）；
            int index = 1;
            end[0] = arr[0];
            dp[0] = 1;
            for(int i =1;i<len;i++){
                if(arr[i]>end[index-1]){
                    end[index++] = arr[i];
                    dp[i] = index;
                }else if(arr[i] == end[index-1]){
                    dp[i] = index;
                }else{
                    // 二分查找递增子序列中第一个大于等于arr[i]的位置l;
                    int l = 0, r = index-1;
                    while(l<r){
                        int mid = l+(r-l)/2;
                        if(end[mid] < arr[i]){
                            l = mid+1;
                        }else{
                            r = mid;
                        }
                    }
                    dp[i] = l+1;
                    end[l] = arr[i];
                }
            }
            int[] res = new int[index];
            for(int i = len-1,j=index;i>=0;i--){
                if(dp[i] == j){
                    res[--j] = arr[i];
                }
            }
            return res;
        }
}
