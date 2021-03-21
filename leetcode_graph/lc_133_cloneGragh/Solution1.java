package lc_133_cloneGragh;

//  题目： 克隆图；
//  描述： 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
//
//        图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
//
//class Node {
//    public int val;
//    public List<Node> neighbors;
//}

//  思路一： DFS
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public Node cloneGraph(Node node) {
        // HashMap 保存已经克隆的结点；
        Map<Node,Node> map = new HashMap<>();
        // DFS；
        return DFS(node,map);
    }
    public Node DFS(Node root,Map<Node,Node> map){
        // 为空，直接返回；
        if(root == null) return root;
        // 如果Map中已经存在root的克隆结点，直接返回；
        if(map.containsKey(root)) return map.get(root);
        // 新建克隆结点；
        Node clone = new Node(root.val,new ArrayList<>());
        // 将克隆结点保存到 map ;
        map.put(root,clone);
        // 遍历结点的邻居结点，加入到克隆结点的邻居中；
        //  遍历过程同时深度递归；
        for(Node node:root.neighbors){
            if(node != null)
                map.get(root).neighbors.add(DFS(node,map));
        }
        // 最后返回克隆结点；
        return clone;
    }
}
