package leetcode_79_ifExistWord;

//      题目：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//           单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
//           同一个单元格内的字母不允许被重复使用。
//           board =
        //[
        //  ['A','B','C','E'],
        //  ['S','F','C','S'],
        //  ['A','D','E','E']
        //]
//          给定 word = "ABCCED", 返回 true
//          给定 word = "SEE", 返回 true
//          给定 word = "ABCB", 返回 false

//      思路： dfs + 回溯；

public class Solution1 {
    int m,n ; // 保存数组横纵坐标长度；
    String word; // 保存所求数组
    char board[][]; // 存储给出数组，遍历查找 i,j 位置是否匹配；
    int[][] move = {{-1,0},{0,1},{1,0},{0,-1}}; // 移动坐标位置；
    boolean maked[][];

    public boolean exist(char[][] board, String word) {
//        初始化全局变量参数；
        this.m = board.length;
        if(m == 0) return false;

        this.n = board[0].length;
        maked = new boolean[m][n];
        this.board = board;
          this.word = word;

         for(int i = 0;i < m ; i++){
             for(int j = 0; j < n;j++){
                 if(dfs(i,j,0)){
                     return true;
                 }
             }
         }
             return false;
    }
//    构造深度递归函数；

    public boolean dfs(int i,int j,int start){
           if(start == word.length()-1) {
               return board[i][j] == word.charAt(start);
           }

           if(board[i][j] == word.charAt(start)){
               maked[i][j] = true;
               for(int k = 0;k < 4;k++){
                   int newI = i + move[k][0];
                   int newJ = j + move[k][1];
                   if(inArea(newI,newJ) && !maked[newI][newJ]){
                      if(dfs(newI,newJ,start+1)){
                          return true;
                      }
                   }
               }
               maked[i][j] = false;
           }
           return false;
    }
//    判断越界函数；
    public boolean inArea(int i, int j){
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
}
