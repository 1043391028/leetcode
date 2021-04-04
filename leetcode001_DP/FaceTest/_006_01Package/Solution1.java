package FaceTest._006_01Package;

//  题目： 01背包；
//   描述： 已知一个背包最多能容纳物体的体积为V
//          现有n个物品第i个物品的体积vi,重量Wi;
//    求当前背包最多能装多大重量的物品
//   示例1
//         输入
//         10,2,[[1,3],[10,4]]
//        返回值  4;

//  思路一： 动态规划；（可空间优化，优化为一维数组）
//

public class Solution1 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 计算01背包问题的结果
         * @param V int整型 背包的体积
         * @param n int整型 物品的个数
         * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
         * @return int整型
         */
        public int knapsack (int V, int n, int[][] vw) {
            // write code here
            if(V == 0 || n == 0 || vw.length == 0) return 0;
            int[][] dp = new int[n+1][V+1];
            for(int i = 1;i<=n;i++){
                for(int j =1;j<=V;j++){
                    if(j>=vw[i-1][0]){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-vw[i-1][0]] + vw[i-1][1]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][V];
        }
}
