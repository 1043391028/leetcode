package leetcode_027_removeElement;

//  题目： 移除元素；
//  描述： 力扣27 略；

//   思路： 遍历数组，遇到与 目标值val 相同的值就将其与最后一个元素交换，
//          并将数组长度len-1,继续下一轮循环， 注意这里下一轮循环并没有把当前正在遍历的下标元素排除；
//                     与目标值不相同就直接遍历下一个；

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0 , len = nums.length;
        //  从第一个元素开始，直到数组长度；
        while(i < len){
            // 相等就和最后一个数交换，并排除该元素（len-1,数组长度-1）
            if(nums[i] == val){
                nums[i] = nums[len-1];
                len--;
                continue;  // 这里跳出该轮循环，继续新的一轮，但是新的一轮并没有把交换过的元素（最后一个）排除；
            }
            // 不相等继续遍历下一个数字；
            i++;
        }
        return len;
    }
}
