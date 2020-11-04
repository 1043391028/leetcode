package leetcode_33_searchNumInRotateArray;

//     题目： 给你一个升序排列的整数数组 nums ，和一个整数 target 。
//
//           假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
//
//           请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//

public class Solution1 {
    public int search(int[] nums, int target) {
        int low = 0 , high = nums.length -1 , mid = 0;

        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[0]){
                if(nums[mid] > target && target > nums[low])
                    high = mid - 1;
                else low = mid + 1;
            }else {
                if (target > nums[mid] && target < nums[high]) low = mid+1;
                else high = mid -1;
            }
        }
        return -1;
    }
}
