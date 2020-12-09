package leetcode002_DFS._0463_perimeterOfLand;

//     题目： 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
//
//            网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，
//            但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//
//            岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
//            网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

//       思路： DFS遍历；
//

public class solution {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0 ; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) // 遇到一个“ 岛屿” 就开始深度遍历；
                 return dfs(grid,i,j);
            }
        }
        return 0;
    }
     int dfs(int[][] array,int i,int j){
//       判断如果不在界内，即递归出界情况；直接返回1；
        if(!(i >= 0 && i < array.length && j >= 0 && j < array[0].length)){
            return 1;
        }
//        如果遍历上下左右为水，则+1；
        if(array[i][j] == 0){
          return 1;
        }
//       遍历进入该区域， 等于2，则遍历过；
        if(array[i][j] == 1) {
            return 0;
        }
         array[i][j] = 2;
        return dfs(array,i-1,j) + dfs(array,i+1,j) + dfs(array,i,j-1) + dfs(array,i,j+1);
    }
}
