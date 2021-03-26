package leetcode004_BinarySearch.lc_704_binary_search;


public class Solution {
    //方法1:搜索目标值索引，但不强调边界
    public int binarySearch(int[] nums, int target) {
        int len = nums.length;
        if (target > nums[len - 1] || target < nums[0]) {
            return -1;
        }
        int right = len - 1;
        int left = 0;

        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //二分查找索引，要求查出左边界值；
    public int leftSearch(int[] numbs, int target) {
        int len = numbs.length;
        if (target > numbs[len - 1] || target < numbs[0]) {
            return -1;
        }
        int right = len ;
        int left = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbs[mid] < target) {
                left = mid+1 ;
            } else if (numbs[mid] > target) {
                right = mid ;      //这里注意,因为查找的为数组中最左边的元素，所以当右边界判定大于或者等于时
                                   //并不能排除右边界，故有right=mid;
            } else if (numbs[mid] == target) {
                right = mid ;
            }
        }
        if(numbs[left] != target)
            return -1;
       return left;
       //一下代码为while（left <= right）条件下判定
       /* if (right <0 || left >= len || numbs[left] != target)
            return -1;
        return left;*/
    }

    //目标值在右边界的索引查找
     int rightBoundSearch(int numbs [] , int target){
         int len = numbs.length;
         if (target > numbs[len - 1] || target < numbs[0]) {
             return -1;
         }
         int right = len - 1;
         int left = 0;

         while(left <= right){
             int mid = left + ( right -left)/2;
             if (numbs[mid] > target){
                 right =mid -1;
             }else if(numbs[mid] < target){
                 left = mid + 1;
             }else if (numbs[mid] ==target){
                 left = mid + 1;
             }
         }
         if (right >= len || left <0 || numbs[right] != target){
             return -1;
         }
        return right ;
     }



    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7, 9, 11, 13, 15, 16, 18, 20};
        int[] nums2 = {1, 3, 5, 5, 5, 5, 5, 15, 16, 18, 20};
        Solution solution = new Solution();

        //int num = solution.binarySearch(nums2,5);
        int num = solution.leftSearch(nums2, 5);
        //int num = solution.rightBoundSearch(nums2, 5);
        System.out.println("查找数的索引为：" + num);
    }
}

