package src.Face_test._002_NC._029_jvzhenSearch;

//  题目： 矩阵查找；
//  描述： 请写出一个高效的在m*n矩阵中判断目标值是否存在的算法，矩阵具有如下特征：
//         每一行的数字都从左到右排序
//         每一行的第一个数字都比上一行最后一个数字大
//  思路一： 二分；
//    思路二： 左下角或者右上角遍历压缩；
public class Solution1 {
    public boolean searchMatrix (int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int len = row*col-1;
        int l = 0,r = len;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(matrix[mid/col][mid%col] == target) return true;
            else if(matrix[mid/col][mid%col] > target) r= mid-1;
            else l = mid+1;
        }
        return false;
    }
}
