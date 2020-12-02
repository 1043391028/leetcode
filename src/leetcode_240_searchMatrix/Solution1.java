package leetcode_240_searchMatrix;

// 题目: 搜索二位矩阵 2;
// 描述: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
//        每行的元素从左到右升序排列。
//        每列的元素从上到下升序排列。

// 思路: 从右上角或者左下角遍历矩阵;

public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lenth = matrix.length, wids = matrix[0].length;
        if(matrix == null || lenth == 0 || wids == 0) return false;
        int i = 0, j = wids-1;
        while(i < lenth && j>=0){
            if(target < matrix[i][j]){
                j--;
            }
            else if(target > matrix[i][j]){
                i++;
            }
            else return true;
        }
        return false;
    }
}
