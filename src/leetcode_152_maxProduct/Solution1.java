package leetcode_152_maxProduct;

//    题目: 乘积最大的数组

//          给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
//          并返回该子数组所对应的乘积。
//    思路：


public class Solution1 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
//        初始最大值设为最小整数，这样只要遍历数组就会更新最大值；
        int max = Integer.MIN_VALUE;
//        初始临时最大最小值设置为 1 ；
        int imin = 1, imax = 1;
        for(int i = 0 ; i < nums.length ; i++){
            //这一步很重要，为了是最大和最小值互换，并且保存下来；
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
//            临时最大值最小值更新
            imax = Math.max(nums[i]*imax, nums[i]);
            imin = Math.min(nums[i]*imin,nums[i]);
//          过程中保存最大值
            max = Math.max(max,imax);
        }

        return max;
    }

}
