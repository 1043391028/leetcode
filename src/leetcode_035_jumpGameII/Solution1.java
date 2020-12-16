package leetcode_035_jumpGameII;

//  题目： 跳跃游戏2；
//  描述： 给定一个非负整数数组，你最初位于数组的第一个位置。
//
//         数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//          你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//  示例:
//          输入: [2,3,1,1,4]
//          输出: 2
//  解释:  跳到最后一个位置的最小跳跃数是 2。
//          从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//  说明:
//         假设你总是可以到达数组的最后一个位置。

//  思路一： 从前往后遍历数组，每遍历到一个数，更新最大可达边界maxIndex = index + nums[index];
//              定义 end 为当前这一步到的最大边界；每当遍历到 i = end 时，更新 end 为最新最大边界 maxIndex;
//                 每走到一次边界，就需要走一步；

public class Solution1 {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        // maxIndex 可以跳到的最大边界； step 走的步数； end 当前这一步能走到的最大边界；
        int maxIndex = 0, step = 0 , end = 0;
        // 注意循环到 nums.lengnth-1 因为假如 跳到 end(边界) = nums.length-1 ，i到end 进入循环，step++多走一步;
        for(int i = 0;i< nums.length-1;i++){
            maxIndex = Math.max(maxIndex,nums[i]+i);
            if(i == end){
                end = maxIndex;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {2,3,1,1,4};
        int result = solution1.jump(nums);
        System.out.println(result);
    }
}
