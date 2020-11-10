package leetcode_48_rotateArray;

//      思路2: 旋转四分之一角（整个矩阵四分之一）

public class Solution2 {
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for(int i =0; i < n/2 + n%2 ; i++ ){
            for(int j = 0; j < n/2;j++){
                int[] temp = new int[4];
                int row = i, col = j ;
//                创建一个数组，保存每次旋转的四个数（如四维数组四个角i = 0, j = 0 ：00，04，44，40）；
                for(int k = 0; k < 4;k++){
                    temp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
//               依次旋转四个数
                for(int k = 0; k < 4; k++){
                   matrix[row][col] = temp[(k+3)%4];
                   int x = row;
                   row = col;
                   col = n - 1 - x;
                }

            }
        }
    }
}
