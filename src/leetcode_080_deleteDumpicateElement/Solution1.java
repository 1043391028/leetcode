package leetcode_080_deleteDumpicateElement;

//  题目: 删除排序数组中重复元素;
//  描述:
//        给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
//
//         不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//  思路:
//        双指针;
//
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // 定义 len 为新数组(实际上是原数组)目前更新到的下标;
        //  初始化为 len = 2, 表示前两个元素必然符合条件,不用更新,从第三个元素开始更新;
        int len = 2;
        //  从前往后遍历数组, 当数组中 num[i] 与新数组更新到末尾倒数第二个不等时就更新至新数组(符合条件);
        //  当 nums[i] == nums[len-2] 说明重复的数超过2个,i++,但是len不变,等待下一个nums[i] != nums[len-2];
        for(int i = 2;i< nums.length;i++){
            if(nums[len-2] != nums[i] ) nums[len++] = nums[i];
        }
        return len;
    }
}
