package lc_1403_minSubRequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  题目： 非递增序列的最小子序列；
//  描述:  给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
//
//         如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
//
//         与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
//
//         注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
//
//示例 1：
//        输入：nums = [4,3,10,9,8]
//        输出：[10,9]
//解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。 
//
//  思路一： 前缀和(数组) + Arrays.sort()
//    思路二： 和思路一一致，不用数组存前缀和，用一个数保存，遍历数组的时候不断更新；
//      思路三： 计数排序 + 求和；
//

public class Solution1 {
    public List<Integer> minSubsequence(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len];
        //  注意，一定要放在计算和的前面；
        Arrays.sort(nums);
        sum[0] = nums[0];
        //  遍历数组，统计前缀和；
        for(int i=1;i<len;i++){
            sum[i] = sum[i-1]+nums[i];
        }
        int sums  = 0;
        List<Integer> res = new ArrayList<>();
        // 因为数组是升序，所以从后往前遍历数组；（题目要求返回较短且较大，贪心，先把最大的取出）
        for(int i =len-1;i>=0;i--){
            sums += nums[i];
            res.add(nums[i]);
            if(i>0 && sums > sum[i-1]) return res;
        }
        return res;
    }
}
