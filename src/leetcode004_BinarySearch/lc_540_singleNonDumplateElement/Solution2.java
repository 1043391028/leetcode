package leetcode004_BinarySearch.lc_540_singleNonDumplateElement;

//  思路二： 异或运算；
//      任何一个数和同一个数 异或运算两次得到自己；

public class Solution2 {
    public int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        for(int i = 1;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }
}
