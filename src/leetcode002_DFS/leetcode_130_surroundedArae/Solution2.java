package leetcode002_DFS.leetcode_130_surroundedArae;

//  思路二: bfs 广度优先遍历;(一般需用队列,比深度优先遍历略微麻烦)
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    // 遍历数组，从四周（边界）上为 ‘O’ 的点进行的深度遍历；
    public void solve(char[][] board){
        if(board == null || board.length == 0) return ;
        for(int i = 0;i<board.length;i++){
            for(int j  =0;j<board[0].length;j++){
                if(i== 0|| j==0|| i == board.length-1||j == board[0].length-1){
                    if(board[i][j] == 'O')
                        bfs(board,i,j);
                }
            }
        }
        // 重新遍历数组，将没有置为‘A’ 的字母，都置为 ‘X’ ;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'A')
                    board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
        return ;
    }
    // 广度优先遍历,不用考虑递归;
    // 移动方向(点坐标移动的方向，上，下，左，右)；
    int[][] tense = {{0,-1},{0,1},{-1,0},{1,0}};
    public void bfs(char[][] board,int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        // 先把开始计进入的点置为‘A’,并把坐标添加进队列；
        board[i][j] = 'A';
        queue.add(i);
        queue.add(j);

        while(!queue.isEmpty()){
            // 队列第一个元素的坐标出列
           int intX = queue.poll();
           int intY = queue.poll();
           //board[intX][intY] = 'A'; 这步可以省掉，因为在添加进队列时，就会提前对进队列的元素置‘A’
            // 四个方向遍历；
           for(int k = 0;k<4;k++){
               int curI = intX + tense[k][0];
               int curJ = intY + tense[k][1];
               if(curI<0 || curI >=board.length || curJ<0 || curJ>=board[0].length)
                   continue;
               if(board[curI][curJ] == 'O'){
                   board[i][j] = 'A';
                   queue.add(curI);
                   queue.add(curJ);
               }
           }
        }
        return ;
    }
}
