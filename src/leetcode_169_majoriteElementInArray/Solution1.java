package leetcode_169_majoriteElementInArray;

//   题目: 多数元素;
//   描述: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//         你可以假设数组是非空的，并且给定的数组总是存在多数元素。

//   思路一: 抵消原则,如果存在多余半数的元素,最后剩下的一定是该元素;

public class Solution1 {
    public int majorityElement(int[] nums) {
        int num = 1;
        int cur = nums[0];
        for(int i =1;i < nums.length;i++){
            if(nums[i] == cur) {
                num++;
            }else num--;
//            num += nums[i] == cur? 1:-1;
            if(num == 0){
                cur = nums[i];
                num = 1;
            }
        }
        return num > 0? cur:-1;
    }
}
