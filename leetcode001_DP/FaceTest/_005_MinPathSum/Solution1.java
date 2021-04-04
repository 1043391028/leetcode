package FaceTest._005_MinPathSum;

//  题目： 带权最小路径和；
//   描述： 给定一个由非负整数填充的m x n的二维数组，现在要从二维数组的左上角走到右下角，
//          请找出路径上的所有数字之和最小的路径。
//  注意：你每次只能向下或向右移动。

//    dp;(下面为未优化空间的)
//        可优化为一维空间；

public class Solution1 {
        /**
         *
         * @param grid int整型二维数组
         * @return int整型
         */
        public int minPathSum (int[][] grid) {
            // write code here
            int row = grid.length, col = grid[0].length;
            int[][] dp = new int[row][col];
            dp[0][0] = grid[0][0];
            for(int i=1;i<row;i++) dp[i][0] = dp[i-1][0] + grid[i][0];
            for(int j = 1;j<col;j++) dp[0][j] = dp[0][j-1] + grid[0][j];
            for(int i = 1;i<row;i++){
                for(int j = 1;j<col;j++){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
            return dp[row-1][col-1];
        }
}
