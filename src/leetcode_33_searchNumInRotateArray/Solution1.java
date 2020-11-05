package leetcode_33_searchNumInRotateArray;

//     题目： 给你一个升序排列的整数数组 nums ，和一个整数 target 。
//
//           假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
//
//           请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//      思路：首先确定左半边和右半边哪一个是有序的，如：1 2 3 4 5 6 7 可以大致分为两类，
//            第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
//              这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
//            第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
//              这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。
//
public class Solution1 {
    public int search(int[] nums, int target) {
        int low = 0 , high = nums.length -1 , mid = 0;

        while(low <= high){
            mid = (high + low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[0]){
                if(nums[mid] > target && target >= nums[0])
                    high = mid -1;
                else
                    low = mid+1;
            }
            else{
                if(nums[mid] < target && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }

        }
        return -1;
    }
}
