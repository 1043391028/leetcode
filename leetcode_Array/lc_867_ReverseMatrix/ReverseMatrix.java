package lc_867_ReverseMatrix;

//    题目： 转置矩阵；
//     描述： 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
//
//           矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

//     思路一：暴力遍历；

public class ReverseMatrix {
    public int[][] transpose(int[][] matrix) {
        int len = matrix.length,wid = matrix[0].length;
        int[][] array = new int[wid][len];
        for(int i = 0;i < len;i++){
            for(int j = 0;j < wid;j++){
                array[j][i] = matrix[i][j];
            }
        }
        return array;
    }
}
