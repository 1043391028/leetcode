package leetcode_287_searchDuplicateNum;

//   思路二: 快慢指针;(很特殊的想法),效率高；

//   核心点: 将数组下标i 和值 nums[i]都作为指针;
//           那么 i = nums[i] 等同于 next = next->next; i = nums[nums[i]] 等同于 next = next->next->next;
//           也即是等同于从快慢指针;
//           因为数组中有重复元素, 所以必定会形成环,而且环是两个重复数之间的元素;

public class Solution2 {
    public int findDuplicate(int[] nums) {
        if(nums == null|| nums.length == 0) return 0;
        int slow = 0, fast = 0;
        // 类似于快慢指针遍历;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        // 新建指针(数组下标)从头开始遍历,slow(原慢指针)从原位置开始遍历;下次两个指针相遇即是重复值;
        int head = 0;
        while(true){
            head = nums[head];
            slow = nums[slow];
            if(slow == head){
                break;
            }
        }
        return slow;
    }
}
