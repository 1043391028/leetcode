package leetcode_036_isValidSuDu;

//  题目： 有效的数独；
//   描述： 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//          数字 1-9 在每一行只能出现一次。
//          数字 1-9 在每一列只能出现一次。
//          数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//    思路： 分别建立三个 boolean类型 二维数组row[][]（行）,col[][]（列）,box[][](表示小方格三行三列)
//           每个数组 第一维分别表示 对应的行，列，和方格位置；
//             第二维表示 数字1-9
//               对应保存的 bool 值表示是否在对应位置 的行、列、方格中出现过；

public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        for(int i =0;i < 9;i++){
            for(int j=0;j< 9;j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(row[i][num] || col[j][num] || box[j/3+(i/3)*3][num]) return false;
                    row[i][num] = true;
                    col[j][num] = true;
                    // 下面方格位置，共9个 分为三行，每行三个，来编号；
                    //  (i/3)*3 是因为i决定了 所在行数 如 i=6,i/3=2 表示前面由两行，所以当前方格坐标位置
                    //  应该 = (i/3)*3(每行3个方格) + j/3(决定方格在改行的第几个)；
                    box[j/3+(i/3)*3][num] = true;
                }
            }
        }
        return true;
    }
}
