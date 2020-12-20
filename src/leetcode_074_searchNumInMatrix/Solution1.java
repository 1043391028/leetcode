package leetcode_074_searchNumInMatrix;

//   题目: 搜索二维矩阵;
//   描述: 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//         每行中的整数从左到右按升序排列。
//         每行的第一个整数大于前一行的最后一个整数。
// 
//  // 思路: 从矩阵右上角元素或者左下角元素收缩查询;

public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int rowlength = matrix.length, collength = matrix[0].length;
        // 数组右上角元素查询;
        int i = 0, j = collength-1;
        while(i < rowlength && j >= 0){
            if(matrix[i][j]== target) return true;
            else if(matrix[i][j] < target) i++;
            else  j--;
        }
        return false;
    }
}
