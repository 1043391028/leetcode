package leetcode_059_SpinMatrix2;

//  题目: 螺旋矩阵2;
//  描述: 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
//  示例:
//         输入: 3
//         输出:
//                [
//                  [ 1, 2, 3 ],
//                  [ 8, 9, 4 ],
//                  [ 7, 6, 5 ]
//                ]
//
//  思路:  同 54 题一样,不过可以不通过边界来判断,只需要压缩边界,大循环来控制循环结束;

public class Solution1 {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int up = 0, down = n-1, left = 0, right = n-1;
        int num = 1; // 初始值1 - n^2;
        // 循环条件 num <= n^2;
        while(num <= n*n){
            for(int i = left;i <= right;i++) arr[up][i] = num++;
            up++; // 只需要压缩边界,不需要判断结束;
            for(int i = up;i <= down;i++) arr[i][right] = num++;
            right--;
            for(int i = right;i >= left;i--) arr[down][i] = num++;
            down--;
            for(int i = down; i >= up; i--) arr[i][left] = num++;
            left++;
        }
        return arr;
    }

    // 测试
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] arr = new int[3][3];
        arr = solution1.generateMatrix(3);
        for(int[] nums: arr){
            for(int num:nums){
                System.out.println(num);
            }
        }
    }
}
