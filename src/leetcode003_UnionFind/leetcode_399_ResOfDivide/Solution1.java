package leetcode003_UnionFind.leetcode_399_ResOfDivide;

// 题目： 399.除法求值；
// 描述： 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
//        其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。
//          每个 Ai 或 Bi 是一个表示单个变量的字符串。
//
//         另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，
//         请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
//
//         返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
//         如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
//
//   注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
//
//示例 1：
//         输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0],
//               queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//         输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
// 解释：
//         条件：a / b = 2.0, b / c = 3.0
//         问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//         结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]

//  思路： 并查集；

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size();
        UnionFind uf = new UnionFind(len*2);
        Map<String,Integer> map = new HashMap<>();
        // 题目中给的的字符串链表，所以将每一个字符串对应一个id并且存储在HashMap中，便于访问；
        int id = 0;
        for(int i = 0;i < len;i++){
            // 依次获取字符
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(1);
            // 给每一个字符对应赋值id,添加进 map;
            if(!map.containsKey(str1)){
                map.put(str1,id++);
            }
            if(!map.containsKey(str2)){
                map.put(str2,id++);
            }
            // 通过 map 找到对应的id,并根据 valus 数组将相关的数（给出相除结果的）加入并查集；
            uf.union(map.get(str1),map.get(str2),values[i]);
        }
        double[] res = new double[queries.size()];
        int index = 0;
        // 遍历要求结果集 利用并查集构建结果数组；
        for(List<String> list:queries){
            // 通过给定要求的结果字符串链表，通过 map 查找对应的id;
            Integer index0 = map.get(list.get(0));
            Integer index1 = map.get(list.get(1));
            // 通过对应的 id ： 如果二者其中一个没有，那么结果肯定不存在；
            //      如果二者都存在， 去并查集中查找对应的根，如果在一个根，利用权重求值，有结果，不在一个根，return-1；
            if(index0 == null || index1 == null ){
                res[index++] = -1.0;
            }else{
                res[index++] = uf.isConected(index0,index1);
            }
        }
        return res;
    }
    class UnionFind{
        private int[] root;
        private double[] weight;
        private int count;
        UnionFind(int n){
            root = new int[n];
            weight = new double[n];
            count = n;
            for(int i = 0;i<n;i++){
                root[i] = i;
                weight[i] = 1.0d;
            }
        }
        // 容易出错点；
        private int find(int i){
            if(root[i] != i){
                // 每一层先把当前结点得父结点保留；目的： 得到父亲结点的权重值（父亲结点到根节点）
                //  每一层都是将 当前结点的权重weight[i] = weight[i] * weight[parent];
                //    由于是先进行的父亲，一直递归直到根结点，每次出来都会更新根结点和权重；
                int parent = root[i];
                root[i] = find(root[i]);
                weight[i] *= weight[parent];
            }
            return root[i];
        }
        // 联合结点：针对两个关联结点，但是他们根结点不同的情况；
        private void union(int x,int y,double value){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;
            root[rootX] = rootY;
            // 这里注意： 能这样计算，说明把两个结点都在各自根的第一（直接）子结点；因为如果不在根的第一层（直接）子节点，
            //              在上面的find（x,y）已经更为各自所在根的第一（直接）子节点；
            weight[rootX] = value*weight[y]/weight[x];
        }
        // 判断：两个字符串对用的id是否相连（在一个根）
        //          是一个根：前者权重/后者权重；
        //              否则： 返回 -1.0；
        public double isConected(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return weight[x]/weight[y];
            }else{
                return -1.0;
            }
        }
    }
}
