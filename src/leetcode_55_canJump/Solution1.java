package leetcode_55_canJump;

//     题目：给定一个非负整数数组，你最初位于数组的第一个位置。
//
//             数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//           判断你是否能够到达最后一个位置。

//      思路：遍历数组，依次算出能到达的下标，如果能达到的下标 >= nums.length - 1 就说明能达到最后；
//            注意遍历过程，不是遍历整个数组，而是遍历到能到达的下标位置；

public class Solution1 {
    public boolean canJump(int[] nums){
        if(nums == null || nums.length == 0) return true;
//       变量 location 记录目前能到达的下标；
        int location = 0;
//        这里注意，i <= location 而不是遍历整个数组；
        for(int i = 0 ; i <= location; i++){
            location = Math.max(location,nums[i] + i);
            if(location >= nums.length - 1)
                return true; // 此思路可以提前跳出循环，
            // 也可以遍历整个数组，当遇到 i > location 说明location位置不更新了；returnfalse;
        }
        return false;
    }

}
