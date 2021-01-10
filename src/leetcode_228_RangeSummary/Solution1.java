package leetcode_228_RangeSummary;

// 题目： 228. 汇总区间；
// 描述： 给定一个无重复元素的有序整数数组 nums 。
//
//        返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，
//        nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
//
//        列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//        "a->b" ，如果 a != b
//        "a" ，如果 a == b
//
// 示例 1：
//          输入：nums = [0,1,2,4,5,7]
//          输出：["0->2","4->5","7"]
//   解释：区间范围是：
//                  [0,2] --> "0->2"
//                  [4,5] --> "4->5"
//                  [7,7] --> "7"
//
//  思路： 双指针；

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> res = new ArrayList<>();
        if(len == 0) return res;
        int i = 0;
        while(i<len){
            // low 标记头指针
            int low = i;
            i++;
            while(i < len && nums[i]-1 == nums[i-1]) i++;
            // high 标记一组连续数的 尾指针
            int high = i;
            StringBuilder sb = new StringBuilder();
            // 先把头加进去，因为无论是一个数还是连续多个数，头是必须加进去的；
            sb.append(Integer.toString(nums[low]));
            // 如果不是一个数，就添加要求格式的；
            if(high - 1 > low){
                sb.append("->");
                sb.append(Integer.toString(nums[high-1]));
            }
            // 把缓冲串的字符串添加到结果中；
            res.add(sb.toString());
        }
        return res;
    }
}
