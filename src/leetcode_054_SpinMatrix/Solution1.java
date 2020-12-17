package leetcode_054_SpinMatrix;

import java.util.ArrayList;
import java.util.List;

//  题目: 螺旋矩阵;
//  描述: 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
//示例 1:
//        输入:
//              [
//                [ 1, 2, 3 ],
//                [ 4, 5, 6 ],
//                [ 7, 8, 9 ]
//              ]
//        输出: [1,2,3,6,9,8,7,4,5]
//
//  思路: 每一行,每一列,环绕遍历,每遍历完一次,把对应的矩阵边界(up, down,left,right)数减去;
//            直到边界值重叠;

public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return null;
        List<Integer> res = new ArrayList<Integer>();
        int row = matrix.length, col = matrix[0].length;

        int up = 0, down = row-1, left = 0, right = col-1;
        while(true){
            for(int i =left;i <= right;i++) res.add(matrix[up][i]);
            //  注意边界条件, 是严格 > ;
            if(++up > down) break;
            for(int i = up;i <= down;i++) res.add(matrix[i][right]);
            if(--right < left) break;
            for(int i = right;i >= left;i--) res.add(matrix[down][i]);
            if(--down < up) break;
            for(int i = down;i >= up;i--) res.add(matrix[i][left]);
            if(++left > right) break;
        }
        return res;
    }
}
