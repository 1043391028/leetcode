package leetcode_283_moveZero;

// 思路二:
//          参考快排思想: 依次从头遍历;把不等等于 0 的元素移动到左边,等于 0 的元素移动到右边;

public class Solution2 {
    public void moveZeroes(int[] nums){
        if(nums == null || nums.length == 0 ) return ;
        int j = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
