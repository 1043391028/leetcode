package jz_12_RouteOfMatrix;

//  题目: 12.矩阵中的路径；
//  描述： 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
//         路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
//          如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
//            例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
//
//             [["a","b","c","e"],
//              ["s","f","c","s"],
//              ["a","d","e","e"]]
//
//       但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//
//  思路： dfs;

public class Solution1 {
    int row = 0;
    int col = 0;
    boolean[][] visited;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        row = board.length;
        col = board[0].length;
        this.board = board;
        visited = new boolean[row][col];
        // 从矩阵每一个位置开始进行深度遍历，只要有一个符合即可返回true；
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(dfs(i,j,0,word)){
                    return true;
                }
            }
        }
        // 都不符合返回false;
        return false;
    }
    // 深度递归；
    public boolean dfs(int i,int j,int index,String s){
        // 递归深度 == s.length() 说明字符串 s 中所有字符都遍历过了；
        if(index == s.length()) return true;
        // 如果出界，或者已经遍历过了、或者当前字符不匹配，说明该路径不符合；
        if(i >= row || i < 0 || j >= col || j<0 || visited[i][j] || board[i][j] != s.charAt(index)) return false;
        // 在界内，匹配，且没有遍历过；标记为遍历过；
        visited[i][j] = true;
        // 这里必须用一个变量保存返回的是否存在结果；
        //  不能直接 return dfs()|| dfs()||....
        boolean res = dfs(i+1,j,index+1,s) || dfs(i-1,j,index+1,s) ||dfs(i,j+1,index+1,s)||dfs(i,j-1,index+1,s);
        // 相当于回溯
        visited[i][j] = false;
        // 回溯返回当前层的结果；
        return res;
    }
}
