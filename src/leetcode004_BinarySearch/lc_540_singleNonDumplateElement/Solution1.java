package leetcode004_BinarySearch.lc_540_singleNonDumplateElement;

// 题目: 有序数组种的单一元素；
//
//描述: 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//
//示例 1:
//        输入: [1,1,2,3,3,4,4,8,8]
//        输出: 2
//
//  思路一： 很棒的思路；二分法；
//           利用二分，不断找中间的偶数位数mid(不为偶数则mid-1)，
//             如果该偶位数和下一位成对，说明前面的也必然成对（因为又偶数个） 左边界l = mid+2（单独的数在右半边）；
//                   如果该位和下一位不成对，则右边界 r = mid-1 (单独的数在 mid 前面);
//            不断压缩，最后 l == r 就是所求数的下标；

public class Solution1 {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int l =0, r = len-1;
        while(l<r){
            int mid = l+ (r-l)/2;
            if(mid%2 != 0){
                mid--;
            }
            if(nums[mid] == nums[mid+1]){
                l = mid+2;
            }else{
                r = mid-1;
            }
        }
        return nums[l];
    }
}
