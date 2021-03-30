package lc_FaceTest_numsOfLand;

// 题目： 岛屿数量；

//  描述： 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
//        岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。

public class Solution1 {
        /**
         * 判断岛屿数量
         * @param grid char字符型二维数组
         * @return int整型
         */
        public int solve (char[][] grid) {
            int res = 0;
            int row = grid.length, col = grid[0].length;
            for(int i = 0;i<row;i++){
                for(int j = 0;j<col;j++){
                    if(grid[i][j] == '1') {
                        res++;
                        DFS(grid,i,j,row,col);
                    }
                }
            }
            return res;
        }
        public void DFS(char[][] grid,int i,int j,int rowlen,int collen){
            if(i>rowlen-1 || i<0 || j>collen-1 || j<0 || grid[i][j] != '1') return ;
            grid[i][j] = 2;
            DFS(grid,i+1,j,rowlen,collen);
            DFS(grid,i,j+1,rowlen,collen);
            DFS(grid,i-1,j,rowlen,collen);
            DFS(grid,i,j-1,rowlen,collen);
        }
}
