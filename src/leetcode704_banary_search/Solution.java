package leetcode704_banary_search;

public class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        if(target > nums[len-1] || target < nums[0]){
            return -1;
        }
        int right =len-1;
        int left = 0;

        while(left<=right){
            int mid = (right+left)>>>1;
            if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums1={1,3,5,7,9,11,13,15,16,18,20};
        Solution solution = new Solution();
        int num=solution.search(nums1,15);
        System.out.println("查找数的索引为："+num);
    }
}

