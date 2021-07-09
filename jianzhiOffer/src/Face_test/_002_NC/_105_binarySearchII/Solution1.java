package src.Face_test._002_NC._105_binarySearchII;

//  题目： 二分查找II;
//  描述： 请实现有重复数字的升序数组的二分查找
//         给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写
//         一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
//示例1
//     输入：
//          [1,2,4,4,5],4
//  返回值：
//          2
//说明：
//      从左到右，查找到第1个为4的，下标为2，返回2

public class Solution1 {
    public int search (int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int len = nums.length;
        int l = 0, r = len-1;
        while(l<r){
            int mid = l + (r-l)/2;
            // 左边界移动（压缩左边界） mid选取的就是左边界，左边界必须得移动，否则死循环；
            //  边界选取原则： 压缩哪边，就选取哪边；本题是找左边第一个元素，所以应该压缩左边界；
            if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid;  // nums[mid] > =  target时，不动；
            }
        }
        return nums[l] == target?l:-1;
    }
}
