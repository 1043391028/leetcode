package src.Face_test._002_NC._034_AllPaths;

//  题目：求路径；
//   描述：一个机器人在m×n大小的地图的左上角（起点）。
//        机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
//        可以有多少种不同的路径从起点走到终点？
//   思路：
//         Dp+空间优化；（画图好理解）

public class Solution1 {
    public int uniquePaths (int m, int n) {
        int[] dp = new int[n];
        //  初始化
        for(int i = 0;i<n;i++){
            dp[i] = 1;
        }
        // m次循环
        for(int i=1;i<m;i++){
            // 每次循环利用上层结果；
            for(int j=1;j<n;j++)
                dp[j] = dp[j-1]+dp[j];
        }
        return dp[n-1];
    }
}
