package leetcode_64_sumOfMinMath;

//  题目：给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//       说明：每次只能向下或者向右移动一步。

//   思路：DFS 动态规划：
//              初始化第一行、第一列表格位置的最小和；
//              然后依次，由上面位置和左边位置最小值来更新计算每一个表格位置的最小路径和；

public class Solution1 {
    public int minPathsum(int[][] grid){
        for(int i = 1;i < grid[0].length;i++) grid[0][i] = grid[0][i] + grid[0][i-1];
        for(int i = 1;i< grid.length;i++) grid[i][0] = grid[i][0] + grid[i-1][0];
        for(int i = 1;i < grid.length;i++ ){
            for(int j = 1; j < grid[0].length;j++){
                grid[i][j] = grid[i][j] + Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
