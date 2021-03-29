package leetcode002_DFS.leetcode_130_surroundedArae;

//   题目: 被围绕的区域;
//   描述: 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
//         找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//   说明: 边界上的o不会被填充;

// 思路一: dfs;
//  大致思路;
//   从边界(矩阵四个边位置),找为'O' 的开始深度遍历,把所有与边界上的‘O’相连的位置置为'A'（这些点是不能被替换的）;
//    从新遍历数组,将置为'A' 的置为'O' 否则置为'X';

public class Solution1 {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return ;
        // 四周开始寻找'O' 并进行深度遍历;
        for(int i = 0;i < board.length;i++){
            for(int j =0 ; j< board[0].length;j++){
                if(i ==0 || i == board.length-1 || j== 0 || j== board[0].length-1){
                    if(board[i][j] == 'O') dfs(board,i,j);
                }
            }
        }
        // 重新遍历,将'A'置为'O',其余置为'X';
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] =='A'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
        return ;
    }
     // 深度遍历;
    public void dfs(char[][] board,int i,int j){
        if(i<0 || i>= board.length || j< 0 || j>= board[0].length)
            return;
        if(board[i][j] != 'O')
            return ;
        board[i][j] = 'A';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
