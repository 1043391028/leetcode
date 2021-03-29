package leetcode001_DP.leetcode_diffrenPath.leetcode_063_differentPath02;

//   题目: 机器人不同路径;(带障碍物)
//   描述: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//         机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//          现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//   思路: dp;(这里是未优化内存的)

public class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0|| obstacleGrid[0].length == 0)
            return 0;
        int len = obstacleGrid.length, wids = obstacleGrid[0].length;
        // 这里.,新建二维 dp数组,比原数组多一行一列,如果不多一行一列,初始化第一行第一列较麻烦(因为障碍物);
        int[][] dp = new int[len+1][wids+1];
        // 初始化条件
        dp[1][0] = 1; // 由状态转移方程决定;dp[1][1] = dp[0][1] + dp[1][0] = 1;(二者需要其中一个初始化为1)
        // dp[0][1] = 1;
        // dp[1][1] = obstacleGrid[0][0]^1; 第一个元素为1(障碍物)的情况;

        for(int i = 1;i <= len;i++){
            for(int j = 1;j<=wids;j++){
                if(obstacleGrid[i-1][j-1] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[len][wids];
    }
}

 //  空间优化;
// public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//     int m = obstacleGrid.length;
//     int n = obstacleGrid[0].length;
//     int[] dp = new int[n + 1];
//     dp[1] = 1;
//     for (int i = 0; i < m; i++) {
//         for (int j = 1; j <= n; j++) {
//             if (obstacleGrid[i][j - 1] == 1) {
//                 dp[j] = 0;//有障碍物
//            } else {//无障碍物
//                dp[j] += dp[j - 1];
//            }
//        }
//    }
//    return dp[n];
//}
