package leetcode_62_differentPath;

//   题目： 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//         机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//         问总共有多少条不同的路径？

//    思路：dfs 动态规划；初始化第一行第一列，然后遍历依次求到下面每一个表格位置的路径；

public class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp =new int[m][n];
//        第一行和第一列初始化为1，只有一条路径
        for(int i = 0;i < n;i++) dp[0][i] = dp[0][i] = 1;
        for(int i = 0; i < m;i++) dp[i][0] = dp[i][0] = 1;
        for(int i = 1;i < m; i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }
         return dp[m-1][n-1];
    }
}

//补充优化代码1；空间复杂度O(2n);
//             实际上只需要额外开辟两行数据即可，当前行和上一行，（最新一行数据需要上一行数据来获得），
//              不断遍历更新，直到遍历到最后；

//    public int uniquePaths(int m, int n) {
//        int[] pre = new int[n];
//        int[] cur = new int[n];
//        Arrays.fill(pre, 1);
//        Arrays.fill(cur,1);
//        for (int i = 1; i < m;i++){
//            for (int j = 1; j < n; j++){
//                cur[j] = cur[j-1] + pre[j];
//            }
//            pre = cur.clone();
//        }
//        return pre[n-1];
//    }

// 补充优化代码2：空间复杂度o(n)
//                  实际上保存一行数据就行（当前行），

//        public int uniquePaths(int m, int n) {
//        int[] cur = new int[n];
//        Arrays.fill(cur,1);
//        for (int i = 1; i < m;i++){
//            for (int j = 1; j < n; j++){
//                cur[j] += cur[j-1] ;  // 解释一下，cur[j]没更新前 其实代表的是上一行当前列的数字，也就是该表格上方表格数；
//            }
//        }
//        return cur[n-1];
//    }
//