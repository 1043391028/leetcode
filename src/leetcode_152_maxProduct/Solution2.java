package leetcode_152_maxProduct;

//   思路二：dp(实际上也就是思路一的详细版本)核心思想都是要保存最大值和最小值；

//           此方法只是占用数组来保存上一个数之前数乘积 的状态（最大值（正值），最小值（负值））；
//  方法特点：思路清晰，动态规划；(效率比思路一还高)
public class Solution2 {
    public int maxProduct(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        // 建立二维数组，保存最大值和最小值，方便后面碰到负数转换；
        int[][] dp = new int[len][2];
        //初始化状态，第一个 dp数组 结果为第一个数；
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        //遍历过程，更换最大值最小值条件为 nums[i] 为负数；
        for(int i = 1;i < len; i++){
            if(nums[i] >= 0){
                dp[i][0] = Math.min(nums[i]*dp[i-1][0],nums[i]);
                dp[i][1] = Math.max(nums[i]*dp[i-1][1],nums[i]);
            }else{
                dp[i][0] = Math.min(dp[i-1][1]*nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i-1][0]*nums[i],nums[i]);
            }
        }
//      最后要重新遍历一般数组，因为结果dp[i]只是保存 i 下标前最大值，有可能会小于 i 之前某个位置 j 之前的最大值；
//       因为 j 如果是负数,那么 i 之前最大值就得从 j 位置后面开始算;
        int res = dp[0][1];
        for(int i =0;i < len;i++ )
        {
            res = Math.max(res,dp[i][1]);
        }
        return res;
    }
}
