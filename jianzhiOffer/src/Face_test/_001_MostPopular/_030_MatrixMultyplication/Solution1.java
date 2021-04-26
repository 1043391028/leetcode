package src.Face_test._001_MostPopular._030_MatrixMultyplication;

// 题目： 矩阵乘法；
//  描述： 给定两个n*n的矩阵A和B，求A*B。（行列式矩阵相乘；）

public class Solution1 {
    public int[][] solve (int[][] a, int[][] b) {
        // write code herew
        if(a == null || a.length == 0) return null;
        int len = a.length;
        int[][] res = new int[len][len];
        for(int i = 0;i<len;i++){
            for(int j =0;j<len;j++){
                for(int n = 0;n<len;n++){
                    res[i][j] += a[i][n]*b[n][j];
                }
            }
        }
        return res;
    }
}
