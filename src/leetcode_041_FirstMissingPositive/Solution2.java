package leetcode_041_FirstMissingPositive;

//  思路二：遍历数组，将数组中正数置换到对应数-1的下标位置；

public class Solution2 {
    public int firstMissingPositive(int[] nums){
        if(nums == null || nums.length == 0) return 1;
        for(int i = 0;i < nums.length;i++){
            // 只有nums[i] > 0 才会有位置，其他的（负数，大于数组长度的）都是无效的位置；
            while(nums[i]>0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for(int i = 0;i< nums.length;i++){
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
    public void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
