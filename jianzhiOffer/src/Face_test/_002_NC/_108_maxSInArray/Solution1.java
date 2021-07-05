package src.Face_test._002_NC._108_maxSInArray;

//  题目: 最大正方形面积;

//  描述:  给定一个由0和1组成的2维矩阵，返回该矩阵中最大的由1组成的正方形的面积

//  思路一: dp;

public class Solution1 {
    public int solve (char[][] matrix) {

        int row = matrix.length, col = matrix[0].length,max = 0;
        int[][] dp = new int[row][col];
        //  初始化第一行和第一列;
        for(int i = 0;i<col;i++){
            if(matrix[0][i] == '1') dp[0][i] = 1;
        }
        for(int i = 0;i<row;i++){
            if(matrix[i][0] == '1') dp[i][0] = 1;
        }

        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                // 核心: 转移方程;遍历位置的左上方最大正方形为,上方\左上角\左方最小值 + 1;
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) +1;
                }else{
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
