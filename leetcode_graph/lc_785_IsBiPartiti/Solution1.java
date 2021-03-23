package lc_785_IsBiPartiti;

// 题目: 判断二分图；
//   思路核心： 二分图，需要满足，将所有的相邻的点分配到两个集合，那么每条边就都在两个结合中了；
//                        也就是两个相邻的点不能再有共同的相邻点；
//                 所以可以用DFS。BFS遍历结点并标记结点，标记过程中如果发现两个相邻结点标记为同一种 返回false;
//                     最后遍历完，返回 true （所有点都满足条件）
//   思路一： 并查集；

public class Solution1 {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        UnionFind uf = new UnionFind(len);
        // 遍历数（点）： 0 ~ n-1, 每个点都有不同或者相同的临结点;
        for(int i = 0;i<len;i++){
            //  将每一个点的邻接点先保存到一个数组；
            int[] arr = graph[i];
            for(int n : graph[i]){
                // 遍历数组，判断临结点和当前结点 i 是否在一个集合；
                //   如果在一个集合就返回 false;
                //   在一个集合： 也就是相连（根一样），说明在前面有一个点和它们（i，n） 相邻，但是现在这轮循环又相邻（肯定不满足）
                if(uf.isConnected(i,n)){
                    return false;
                }
                // 将当前邻接点（所有graph[i] 里面的数，也就是和 i 相邻的点）
                uf.union(arr[0],n);
            }
        }
        return true;
    }
 /// 构建并查集；
    class UnionFind{
        private int size;
        private int[] roots;
        UnionFind(int n){
            this.size = n;
            roots = new int[n];
            for(int i = 0;i<n;i++){
                roots[i] = i;
            }
        }
        public int find(int i){
            if(roots[i] != i){
                roots[i] = find(roots[i]);
            }
            return roots[i];
        }

        public void union(int i,int j){
            if(find(i) != find(j)){
                roots[find(i)] = roots[find(j)];
            }
        }
        // 判断两节点是否是一个根（在这里是指是否是分到一个集合里）
        public boolean isConnected(int i , int j){
            return find(i) == find(j);
        }
    }
}
