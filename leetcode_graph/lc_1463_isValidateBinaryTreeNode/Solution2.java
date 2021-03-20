package lc_1463_isValidateBinaryTreeNode;

//  思路二： 并查集；
//

public class Solution2 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        // 遍历数组；
        for(int i =0;i<n;i++){
            // 判断： 1. 如果当前左（右）结点的父结点不是初始值（说明已经有了父亲结点）当前父结点重复返回false;
//                   2. 如果当前结点和 i 结点（当前遍历的结点） 同属于一个根，说明在一个环里，不能构成树；
            if(leftChild[i] != -1){
                if(uf.roots[leftChild[i]] != leftChild[i] || uf.isConected(i,leftChild[i])) return false;
                uf.union(leftChild[i],i);
            }
            if(rightChild[i] != -1){
                if(uf.roots[rightChild[i]] != rightChild[i] || uf.isConected(i,rightChild[i])) return false;
                uf.union(rightChild[i],i);
            }
        }
        return uf.getSize() == 1;
    }

      // 构建并查集；
    public class UnionFind {
        private int size;
        private int[] roots;
        public UnionFind(int n){
            this.size = n;
            roots = new int[n];
            for(int i = 0;i<n;i++){
                roots[i] = i;
            }
        }
        public int find(int n){
            while(n != roots[n])
                n = roots[n];
            return n;
        }
        public void union(int i,int j){
            int rootI = roots[i];
            int rootJ = roots[j];
            if(rootI != rootJ){
                roots[i] = roots[j];
                size--;
            }
        }
        // 判断点是否相连（根是否是一个）
        public boolean isConected(int i,int j){
            return find(i) == find(j);
        }
        public int getSize(){
            return this.size;
        }
    }
}
