package leetcode_073_setZeroInMatrix;

//  题目:  矩阵置0;
//  描述:
//          给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//  进阶:
//          一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
//          一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
//          你能想出一个常数空间的解决方案吗？


public class Solution1 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int rowlength = matrix.length, collength = matrix[0].length;
        boolean row0 = false, col0 = false;
        for(int i = 0;i<rowlength;i++){
            if(matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for(int i = 0;i < collength;i++){
            if(matrix[0][i] ==0){
                row0 = true;
                break;
            }
        }
        for(int i = 1;i<rowlength;i++){
            for(int j = 1;j<collength;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i< rowlength;i++){
            for(int j = 1;j<collength;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j] =0;
            }
        }
        if(row0) {
            for(int i = 0;i<collength;i++) matrix[0][i] =0;
        }
        if(col0){
            for(int i = 0;i<rowlength;i++) matrix[i][0] = 0;
        }

    }
}
