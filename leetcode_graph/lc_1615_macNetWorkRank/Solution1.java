package lc_1615_macNetWorkRank;

// 题目： n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。
//       每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
//
//       两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。
//        如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
//
//         整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
//
//        给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
//
//  思路： 遍历数组，构建有向图，各个点（数）的出度，以及两点间的有向边；
//           构建完毕，遍历结点（数），依次找它于其它点（数）的路径和： 两个点的出度和 - 共同的有向边；
//             在此过程更新最大值，遍历完毕，可以得到最大值；

public class Solution1 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int rank[][] = new int[n][n];
        int out[] = new int[n];
        for(int arr[]:roads){
            rank[arr[0]][arr[1]]++;
            rank[arr[1]][arr[0]]++;
            out[arr[0]]++;
            out[arr[1]]++;
        }
        int maxRank = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                maxRank = Math.max(maxRank,out[i] + out[j] - rank[i][j]);
            }
        }
        return maxRank;
    }
}
