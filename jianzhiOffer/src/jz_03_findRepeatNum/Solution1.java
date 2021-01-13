package jz_03_findRepeatNum;

//   题目： 数组中重复的数字；
//   描述： 找出数组中重复的数字。
//
//         在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
//           但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
//示例 1：
//        输入：
//             [2, 3, 1, 0, 2, 5, 3]
//        输出：2 或 3
//  思路： 数字范围是 0 ~ n-1 ，从头遍历数组，找寻每个与下标相等的的元素；
//             找的方法： 与值对应下标的元素交换，交换之前先判断交换的元素是否相等；
//                          相等就返回，否则交换，直到nums[i] = i;
public class Solution1 {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for(int i = 0;i<len;i++){
            while(nums[i] != i) {
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                // 交换元素：当前下标位置 元素 和数组中元素值代表的下标的元素；
                int temp = nums[i]; // 保存元素值，作为交换的下标；
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
