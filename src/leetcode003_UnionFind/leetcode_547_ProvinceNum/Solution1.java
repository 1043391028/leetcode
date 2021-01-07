package leetcode003_UnionFind.leetcode_547_ProvinceNum;

//  题目： 省份数量；
//  描述： 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
//           且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
//
//         省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
//
//          给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
//          而 isConnected[i][j] = 0 表示二者不直接相连。
//
//          返回矩阵中 省份 的数量。
// 示例 1：
//           输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//           输出：2
// 示例 2：
//           输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//           输出：3
//
//   思路一： 并查集；
//   思路二： dfs；
//           遍历数组，visited[len] 保存是否被遍历过，每次遍历一个新结点（没有遍历过的）cnt++(记录结果)；
//             将遍历过的点i 对应的visted[i]置为true;
//              然后由该点进入递归，进入递归条件是isconnected[i][j] == 1（也就是与当前点相接的点）
//                  把i 相接的点j 对应的visited[j]都置为true，防止重复访问；

public class Solution1 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0;i<n; i++){
            for(int j = i+1;j<n;j++){
                uf.union(i,j);
            }
        }
        return uf.size;
    }
    class UnionFind{
        int[] root;
        int size;
        public UnionFind(int n){
            root = new int[n];
            for(int i = 0;i<n;i++){
                root[i] = i;
            }
            size = n;
        }
        public int find(int i){
            if(root[i] == i){
                return i;
            }
            return root[i] = find(root[i]);
        }
        public void union(int i,int j){
            int numi = root[i];
            int numj = root[j];
            if(numi != numj){
                root[numi] = root[numj]; // 这一步很重要，更新相连结点的根结点（省份）为一个根结点（省份）
                                          //  否则会出现数组中所有省份相连（isconnencted[i][j] == 1）时，返回结果为0；
                size--;
            }
        }
    }
}
