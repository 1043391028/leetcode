package leetcode_200_NumofLand;

//  题目： 岛屿数量；
//  描述： 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//       此外，你可以假设该网格的四条边均被水包围。
//
// 思路一：并查集；

public class Solution1 {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows == 0) return 0;

        Unionfind uf = new Unionfind(rows*cols);
        int directions[][] = {{0,1},{1,0}};
        int space = 0;
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    for(int[] direction: directions){
                        int newI = i+direction[0];
                        int newJ = j+direction[1];
                        if(newI<rows && newJ<cols && grid[newI][newJ] == '1')
                            uf.union(i*cols+j,newI*cols+newJ);
                    }
                }else space++;
            }
        }
        return uf.count-space;
    }

    class Unionfind{
        int[] parent;
        int count;
        public Unionfind(int n){
            parent = new int[n];
            count = n;
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int i){
            while(parent[i] != i){
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return parent[i];
        }
        public void union(int i,int j){
            int parentI = find(i);
            int parentJ = find(j);
            if(parentI == parentJ){
                return ;
            }
            parent[parentI] = parentJ;
            count--;
        }
    }
}
