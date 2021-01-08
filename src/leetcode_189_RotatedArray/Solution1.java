package leetcode_189_RotatedArray;

// 题目： 旋转数组；
// 描述: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//       输入: [1,2,3,4,5,6,7] 和 k = 3
//       输出: [5,6,7,1,2,3,4]
// 解释:
//       向右旋转 1 步: [7,1,2,3,4,5,6]
//       向右旋转 2 步: [6,7,1,2,3,4,5]
//       向右旋转 3 步: [5,6,7,1,2,3,4]
//
//  思路一： 暴力解法；（时间复杂度kn）
//           循环k次，每次从后往前依次遍历改变数组元素： nums[i] = nums[i-1];
///             每次循环 temp 保存第一个元素， 最后nums[0] = temp;

public class Solution1 {
    public void rotate_1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
