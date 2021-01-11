package leetcode003_UnionFind.leetcode_1202_smallestStringWithSwaps;

//  题目： 1202.交换字符串中的元素；
//  描述： 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，
//         其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
//
//         你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
//
//          返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
//
// 示例 1:
//         输入：s = "dcab", pairs = [[0,3],[1,2]]
//         输出："bacd"
//   解释：
//         交换 s[0] 和 s[3], s = "bcad"
//         交换 s[1] 和 s[2], s = "bacd"

//   思路： 并查集；

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs == null || pairs.size() == 0) return s;
        int len = s.length();
        // 构建并查集；
        UnionFind uf = new UnionFind(len);
        // 根据 pairs 中的元素合并并查集；
        for(List<Integer> list:pairs){
            uf.union(list.get(0),list.get(1));
        }
        // 构造 HashMap 保存某一个根下的所有字符，使用优先队列，为了给属于某一根下的结点字符按照字典序排序；
        HashMap<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            int index = uf.find(i);
            PriorityQueue<Character> queue = map.getOrDefault(index,new PriorityQueue<>());
            queue.offer(s.charAt(i));
            map.put(index,queue);
        }
        // 下面才是真正的重构字符串顺序；根据优先队列；
        StringBuilder sb = new StringBuilder();
        // 从前往后遍历字符串，每次找到字符下标对应的根；然后根据根找到优先队列，把队列里面最顶端（字典序中最靠前的）
        //     出队，这样保证了前面位置字符总是能先放最小的字符；直到排完最后一个位置s.length()-1；
        for(int i = 0;i<len;i++){
            int index = uf.find(i);
            sb.append(map.get(index).poll());
        }
        return sb.toString();
    }
    // 构建并查集类：depth表示结点的秩；root表示结点的根；count 表示树群（不同根）的数目
    class UnionFind {
        private int[] root;
        private int[] depth;
        private int count;
        // 初始化；
        UnionFind(int n){
            root = new int[n];
            depth = new int[n];
            count = n;
            for(int i = 0;i<n;i++){
                root[i] = i;
                depth[i] = 1;
            }
        }
        // 查找根，并压缩路径；
        private int find(int index){
            if(root[index] == index) return index;
            return root[index] = find(root[index]);
        }
        //  联合相关的结点；
        private void union(int x,int y){
            int xx = find(x);
            int yy = find(y);
            if(xx == yy) return ;
            if(depth[xx] > depth[yy]){
                root[yy] = xx;
            }else if(depth[xx] < depth[yy]){
                root[xx] = yy;
            }else{
                root[xx] = yy;
                depth[yy] +=1;
            }
        }
        // 返回共有多少树群；
        private int getCount(){
            for(int i = 0;i < root.length;i++){
                if(root[i] == i) count++;
            }
            return count;
        }
        // 判断结点是否在同一颗树上，是否同根；
        private boolean isConnected(int x,int y){
            return root[x] == root[y];
        }
    }
}
