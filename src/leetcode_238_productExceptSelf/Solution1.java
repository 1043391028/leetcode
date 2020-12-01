package leetcode_238_productExceptSelf;

//   题目: 除自身以外数组的乘积;
//         给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
//          其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//   示例:
//         输入: [1,2,3,4]
//         输出: [24,12,8,6]
//   提示： 题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//
//   说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//   进阶：
//        你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
// 思路一:
//        从前往后遍历数组;一临时int 变量 temp保存下标 i 之前的数乘积;求
public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        // 判空
        if(nums == null || nums.length == 0) return null;
        // 新建一数组res[]和临时数temp;数组保存结果,temp 保存下标 i 之前的乘积;
        int len = nums.length , temp = 1;
        int[] res = new int[len];
        res[0] =1;// 初始化第一个数,因为前面没有数,所以为1;
        // 第一轮遍历(从前往后,第二个元素开始,第一个初始化过了);
        // 结束后, res数组中保存的结果是下标 i 之前数的乘积;
        for(int i = 1;i < len;i++){
            res[i] = nums[i-1]*temp;
            temp *= nums[i-1];
        }
        // 第二轮遍历(从后往前,倒数第二个开始,倒数第一个已经是最终结果);
        // 这次是为了把下标 i 后面的数乘积乘进去;;temp 更新为 1;
        temp = 1;
        for(int j = len-2;j>=0;j--){
            res[j] *= nums[j+1]*temp;
            temp *= nums[j+1];
        }
        // 返回最终结果;
        return res;
    }
}
