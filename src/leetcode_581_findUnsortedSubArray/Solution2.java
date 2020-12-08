package leetcode_581_findUnsortedSubArray;


//
//  思路一:
//         大致思路:从左边和从右边分别找第一个不合适的边界;
//    具体: 1. 从左边遍历,初始化最大值max为nums[0],依次从左往右遍历数组,
//             遇到小于max的说明nums[i]左边有大于它的数,需要变动,右边界r更新为i;(右边界初始化为-1,防止数组本身就是升序的情况)
//               一直往后遍历到最后,右边界更新为最右边的一个不正确的(左边有大于该位置元素的数)下标位置i;
//          2. 同理,从右往左找左边界l, min初始化为nums[len-1](最后一个元素),碰到大于min的数说明该位置需要变动;
//             直到遍历到最左边,找出最左边一个不对的元素位置i;
public class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int len  = nums.length , l =0,r = -1;
        int max =nums[0], min = nums[len-1];
        for(int i = 0;i<len;i++){
            if(max > nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
        }
        for(int j =len-1;j>=0;j--){
            if(nums[j]> min){
                l = j;
            }else{
                min = nums[j];
            }
        }
        return r-l+1;
    }
}
