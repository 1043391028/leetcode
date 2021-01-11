package leetcode003_UnionFind.leetcode_1202_smallestStringWithSwaps;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs == null || pairs.size() == 0) return s;
        int len = s.length();
        UnionFind uf = new UnionFind(len);
        for(List<Integer> list:pairs){
            uf.union(list.get(0),list.get(1));
        }
        HashMap<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            int index = uf.find(i);
            PriorityQueue<Character> queue = map.getOrDefault(index,new PriorityQueue<>());
            queue.offer(s.charAt(i));
            map.put(index,queue);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<len;i++){
            int index = uf.find(i);
            sb.append(map.get(index).poll());
        }
        return sb.toString();
    }
    class UnionFind {
        private int[] root;
        private int[] depth;
        private int count;
        UnionFind(int n){
            root = new int[n];
            depth = new int[n];
            count = n;
            for(int i = 0;i<n;i++){
                root[i] = i;
                depth[i] = 1;
            }
        }

        private int find(int index){
            if(root[index] == index) return index;
            return root[index] = find(root[index]);
        }

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

        private int getCount(){
            for(int i = 0;i < root.length;i++){
                if(root[i] == i) count++;
            }
            return count;
        }
        private boolean isConnected(int x,int y){
            return root[x] == root[y];
        }
    }
}
