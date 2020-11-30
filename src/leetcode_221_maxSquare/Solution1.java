package leetcode_221_maxSquare;

//  题目： 最大正方形；
//  描述： 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

//  思路： dp;
//        （solution2和本思路一样，只是空间优化）但是思想很典型，
//         很多 dp 方法都可以以此思想优化空间；只是保存前一行数据和当前行;


public class Solution1 {
    public int numIslands(char[][] matrix) {
        int len = matrix.length;
        int wids = matrix[0].length;
//        初始化dp数组；多出一行一列；第一行第一列都为0（界外）；
//        本题 dp[i][j] i,j表示第 i行 j列坐标对应最大矩形（左上部分方格决定）；
        int[][] dp = new int[len+1][wids+1];
        int maxWids = 0; // 初始化最大值；
        for(int i =1;i <= len;i++){
            for(int j=1;j <= wids;j++){
                // 如果当前方格为 1 ，则选择左上，左，上面最小的+1；
                if(matrix[i-1][j-1] == '1') dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                else dp[i][j] = 0; // 这里esle可以不要；默认为0；
                maxWids = Math.max(maxWids,dp[i][j]); // 更新最大值；
            }
        }
        return maxWids*maxWids;
    }
}

