package lc_1267_countOfServer;

//  题目： 统计参与通信的服务器数量；

//  描述： 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
//
//        如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
//
//        请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
//  思路一： （两次遍历）
//          新建行/列标志位rows[n],cols[n]，（标记某行某列服务器数量）
//            第一遍遍历，统计某行某列的服务器数量；
//            第二次遍历，统计符合条件的数量；

public class Solution1 {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        // 第一次遍历；
        for(int i = 0;i < row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 1){
                    cols[j]++;
                    rows[i]++;
                }
            }
        }
        // 第二次遍历；
        int count  = 0;
        for(int i = 0;i< row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) count++ ;
            }
        }
        return count;
    }
}
