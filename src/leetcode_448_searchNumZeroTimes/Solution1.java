package leetcode_448_searchNumZeroTimes;

import java.util.ArrayList;
import java.util.List;

//   题目: 找到所有数组中消失的(缺失)数字;
//   描述: 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
//        找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
//        您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内
//
//   思路: 将数组元素代表的数字转换为下标索引;将对应索引的数组数字 + nums.length;
//           这样凡是出现的元素所对应的元素都 > nums.length;
public class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        // 将数组中元素大小对应的下标位置的数 + len(数组长度);
        for(int i= 0;i< nums.length;i++){
            int index = (nums[i]-1)%len; // 如果不取余就会有元素大于len 出现越界;
            nums[index] +=len;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= len) res.add(i+1); // nums[i] < len 说明没有nums[i] -1 的下标与其对应;
                                             // 推出没有出现的元素 nums[i] = i+1;
        }
        return res;
    }
}
