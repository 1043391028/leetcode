package leetcode_081_searchNumInCircleArray;

//   题目: 搜索旋转排序数组;
//   描述:
//         假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//          (例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//
//         编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

//   进阶:
//         这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
//         这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
//
//   思路:  具有重复元素的旋转数组,旋转后具有三种可能:
            // 1. 1,0,1,1,1,1 这种情况无法判断左半边和右半边的升降序情况;
            // 2. 4,5,6,7,1,2,3 左半边有序;
            // 3. 6,7,1,2,3,4,5 右半边有序;

public class Solution1 {
    public boolean search(int[] nums, int target) {
        int  left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target) return true;
            // 第一种情况,
            if(nums[mid] == nums[left]){
                left++;
                continue;
            }
            // 第二种情况;
            if(nums[mid] > nums[left]){
                // 判断目标数 target 在左半边升序序列范围内;否则在另外半边找;
                if(nums[mid] > target && nums[left] <= target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{ // 第三种情况;
                // 判断在右半边升序序列范围内,否则取另外半边查找;
                if(nums[mid] < target && nums[right] >= target){
                    left = mid +1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}
