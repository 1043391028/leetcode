package leetcode_35_search_insert;

//   思路二： 二分法遍历；

public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0, end = nums.length; // *** 这里千万注意，此题，右边界一定要初始化为 数组长度；
                                          //  因为可能遍历到最后，退出while 循环后左边界 == end == nums.length;
                                          //  或者像 solution 方法中，提前判断target> nums[len-1]的情况；
        while(start < end){
            int mid = start - (start-end)/2;
            if(nums[mid] == target) return mid; // 如果找到target就直接返回下标；
//                                              //  没找到的话，找到的就是大于 target 的元素位置；
            else if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
