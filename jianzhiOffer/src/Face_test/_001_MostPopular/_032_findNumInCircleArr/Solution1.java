package src.Face_test._001_MostPopular._032_findNumInCircleArr;

//  题目：子啊旋转数组中找寻目标数；
//  描述： 给定一个整数数组nums，按升序排序，数组中的元素各不相同。
//         nums数组在传递给search函数之前，会在预先未知的某个下标 t（0 <= t <= nums.length-1）上进行旋转，
//         让数组变为[nums[t], nums[t+1], ..., nums[nums.length-1], nums[0], nums[1], ..., nums[t-1]]。
//  比如，数组[0,2,4,6,8,10]在下标2处旋转之后变为[6,8,10,0,2,4]
//        现在给定一个旋转后的数组nums和一个整数target，请你查找这个数组是不是存在这个target，
//         如果存在，那么返回它的下标，如果不存在，返回-1

public class Solution1 {
    public int search (int[] nums, int target) {
        // write code here
        int l =0, r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[l]){
                if(nums[l] <= target && target < nums[mid])
                   r = mid-1;
                else l = mid+1;
            }else{
                if(nums[mid] < target && nums[r]>=target)
                      l = mid+1;
                else r = mid-1;
            }
        }
        return -1;
    }
}
