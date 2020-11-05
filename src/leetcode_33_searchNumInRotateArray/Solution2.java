package leetcode_33_searchNumInRotateArray;

//   题目描述：
//      153. 寻找旋转排序数组中的最小值
//         假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
//
//          请找出其中最小的元素。
//      思路： 寻找最小值，用二分法不断收缩边界（排除最小值不在的一边），最后返回的即是最小值；
public class Solution2 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
