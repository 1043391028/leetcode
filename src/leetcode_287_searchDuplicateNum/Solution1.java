package leetcode_287_searchDuplicateNum;

//   题目: 寻找重复数;
//   描述: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
//
//  示例1:
//         输入: [1,3,4,2,2]
//         输出: 2
//   说明：
//         不能更改原数组（假设数组是只读的）。
//         只能使用额外的 O(1) 的空间。
//         时间复杂度小于 O(n2) 。
//         数组中只有一个重复的数字，但它可能不止重复出现一次。
// 思路一: 二分思想;(时间复杂度: o(N*logN), 复杂度并不低,思路二: 双指针时间复杂度 o(N))
//         (下面步骤中中间值 mid 相当于寻找的数值,每次循环更新数组中 <= mid 的个数cnt,
//           如果cnt>mid,说明 left - mid 之间的数肯定有重复,反之则在 mid+1 ~ right 之间的数中;
//            依次循环,直到左右边界相等,跳出循环,边界值即为要找的重复数)
//         1. 找中点mid,设定统计个数值 cnt ;
//         2. 遍历数组,统计 >= mid 的个数;
//         3. 判断个数是否 大于中间值 mid;
//            大于: 说明重复数值在mid左边,(即 <mid),更新边界值,right = mid;
//            小于: 说明重复数值在mid右边,(即 >mid),更新边界值,left = mid + 1;
//        4. 第一轮循环结束,新一轮循环开始;

public class Solution1 {
    public int findDuplicate(int[] nums) {
        // 初始判断;
        if(nums == null|| nums.length == 0) return 0;
        // 设定初始边界值;
        int left = 1, right = nums.length-1;
        // 循环二分查找;边界条件 (left < right)
        while(left < right){
            // 设定中值
            int mid = (left + right)>>>1;
            int cnt = 0; // 统计个数
            for(int num: nums){
                if(num <= mid) cnt++;
            }
            // 判断,更新边界,注意条件;由上面 num <= mid 决定;
            if(cnt > mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
