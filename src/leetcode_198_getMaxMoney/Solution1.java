package leetcode_198_getMaxMoney;

//    题目: 打家劫舍;
//    描述: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
//          影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
//           如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//        给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//    思路: dp

public class Solution1 {
    public int rob(int[] nums) {
//       这里需要判空,如果数组长度为 0 , 下面初始化dp[1]会越界;
        if(nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len+1];
//      初始化, 0 代表没有元素时;1 代表有 1 个元素;
        dp[0] = 0;
        dp[1] = nums[0];
//       下标 i 代表第i 个元素之前(包括 i )最大和;
        for(int i = 2;i <= len;i++){
//          由于不能选挨着的元素
//          两种选择的最大值: 1.当前元素值 + dp[i-2];
//                          2.不选当前元素 , dp[i-1];
            dp[i] = Math.max(dp[i-1],nums[i-1] + dp[i-2]);
        }
        return dp[len];
    }
}

//  扩展: 上述方法属于标准动态规划;可以进行空间优化
//        在动态遍历求 dp 值的时候,可以只保存最后结果的前两个值;

//     public int rob(int[] nums) {
//       这里需要判空,如果数组长度为 0 , 下面初始化dp[1]会越界;
//        if(nums == null || nums.length == 0) return 0;

//        初始化前两个值,可以以此为基本往下求;
//        int pre = 0;
//        int cur = nums[0];
//         不断更新第 i+1 个元素之前的最大值;两种情况;思想同上;
//        for(int i = 1;i < len;i++){
//            int temp = cur;
//            cur = Math.max(cur,nums[i] + pre);
//            pre = temp;
//        }
//        return cur;
//    }