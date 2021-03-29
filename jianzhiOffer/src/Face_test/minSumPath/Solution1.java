package Face_test.minSumPath;

// 题目： 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
//        路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。

//  下面方法用的是二维数组动态规划；（可以进行压缩，优化为一维数组，节省空间）

public class Solution1 {
        public int minPathSum (int[][] matrix) {
            // write code here
            int row = matrix.length, col = matrix[0].length;
            int[][] dp = new int[row][col];
            dp[0][0] = matrix[0][0];
            for(int i = 1;i<col;i++) dp[0][i] = matrix[0][i] + dp[0][i-1];
            for(int i = 1;i<row;i++) dp[i][0] = matrix[i][0] + dp[i-1][0];
            for(int i = 1;i<row;i++){
                for(int j = 1;j<col;j++){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
            return dp[row-1][col-1];
        }

        // 压缩空间
    //     public int minPathSum (int[][] matrix) {
    //        int m = matrix.length;
    //        int n = matrix[0].length;
    //        int[] results = new int[n];
    //        results[0] = matrix[0][0];
    //        for (int j = 1;j < n;j++) {
    //            results[j]=results[j-1]+matrix[0][j];
    //        }
    //        for (int i = 1;i < m;i++) {
    //            results[0]+=matrix[i][0];
    //            for (int j = 1;j < n;j++) {
    //                results[j]=matrix[i][j]+Math.min(results[j-1], results[j]);
    //            }
    //        }
    //        return results[n-1];
    //    }
}
