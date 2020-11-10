package leetcode_48_rotateArray;

//     题目：给定一个 n × n 的二维矩阵表示一个图像。
//
//           将图像顺时针旋转 90 度。
//
//       说明：
//           你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

//      思路一： 先对称反转， 然后每一行首尾依次对换；

public class Solution1 {
    public void rotate(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length==0 ) return ;
        for(int i = 0; i < matrix.length; i++){
//            第二层循环注意，要从 j = i 开始；是从对角线两边对换；如果还从0开始就会再反转回来；
            for(int j = i; j< matrix[0].length;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 -j] = temp;
            }
        }
    }
}
