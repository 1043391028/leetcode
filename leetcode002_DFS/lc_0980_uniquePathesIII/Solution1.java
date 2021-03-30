package lc_0980_uniquePathesIII;

//  题目： 不同路径III;
//  描述: 在二维网格 grid 上，有 4 种类型的方格：
//
//         1 表示起始方格。且只有一个起始方格。
//         2 表示结束方格，且只有一个结束方格。
//         0 表示我们可以走过的空方格。
//         -1 表示我们无法跨越的障碍。
//   返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
//
//    每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
//

public class Solution1 {
    public int uniquePathsIII(int[][] grid) {
        int res = 0,row = grid.length,col = grid[0].length;
        int count = 0,inI = 0,inJ = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 0 || grid[i][j] == 2){
                    count++;
                }
                if(grid[i][j] == 1){
                    inI = i;
                    inJ = j;
                }
            }
        }
        res = DFS(grid,count,inI,inJ);
        return res;
    }
    public int DFS(int[][] grid,int count,int i,int j){
        if(i>grid.length-1 || i<0 || j>grid[0].length-1 || j<0 || grid[i][j] == -1) return 0;
        if(grid[i][j] == 2) return count == 0?1:0;
        grid[i][j] = -1;
        int res = 0;
        res += DFS(grid,count-1,i-1,j);
        res += DFS(grid,count-1,i,j-1);
        res += DFS(grid,count-1,i,j+1);
        res += DFS(grid,count-1,i+1,j);
        grid[i][j] = 0;
        return res;
    }
}
