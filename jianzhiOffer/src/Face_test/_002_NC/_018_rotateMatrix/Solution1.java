package src.Face_test._002_NC._018_rotateMatrix;

//  题目：顺时针旋转矩阵；
//  描述：
//        有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
//
//       给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。

//    思路一： 找规律；
//             顺时针旋转后：arr[i][j] = arr[row-j-1][i];

public class Solution1 {
    public int[][] rotateMatrix(int[][] mat, int n) {

        int row = mat.length, col = mat[0].length;
        int[][] newArr = new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j=0;j<col;j++){
                newArr[i][j] =  mat[row-j-1][i];
            }
        }
        return newArr;
    }
}
