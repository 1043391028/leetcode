package leetcode_148_sortList;

//   思路二：dp(实际上也就是思路一的详细版本)核心思想都是要保存最大值和最小值；

//           此方法只是占用数组来保存上一个数之前数乘积 的状态（最大值（正值），最小值（负值））；
//  方法特点：思路清晰，动态规划；(效率比思路一还高)
public class Solution2 {
    public int maxProduct(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for(int i = 1;i < len; i++){
            if(nums[i] >= 0){
                dp[i][0] = Math.min(nums[i]*dp[i-1][0],nums[i]);
                dp[i][1] = Math.max(nums[i]*dp[i-1][1],nums[i]);
            }else{
                dp[i][0] = Math.min(dp[i-1][1]*nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i-1][0]*nums[i],nums[i]);
            }
        }

        int res = dp[0][1];
        for(int i =0;i < len;i++ )
        {
            res = Math.max(res,dp[i][1]);
        }
        return res;
    }
}
