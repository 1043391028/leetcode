package leetcode_035_jumpGameII;

//  思路二 ：  定义最后到达的位置 index = nums.length-1;
//               从前往后遍历数组，找到第一个可以到达该位置的下标i，更新 index = i, step++；
//                      直到 index = 0,退出循环，返回step;

public class Solution2 {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int index = nums.length-1, step = 0;
        while(index != 0){
            for(int i = 0 ;i < index;i++ ){
                if(nums[i] >= index - i) {
                    index = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}

