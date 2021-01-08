package leetcode_133_CloneGraph;

//  题目： 133.克隆图；
//  描述; 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
//
//        图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
//
// 测试用例格式：
//             简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），
//             以此类推。该图在测试用例中使用邻接列表表示。
//
//             邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
//
//              给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
//

import java.util.ArrayList;
import java.util.HashMap;

public class Solution1 {
    class Solution {
        public Node cloneGraph(Node node) {
            HashMap<Node,Node> map = new HashMap<>();
            return dfs(node,map);
        }
    }
    // 深度优先；克隆root结点，并返回克隆结点；
    //   因为时深度递归，所以每进入一个结点，会先深度进入该节点邻接表的结点（也就是先克隆邻接表中的结点，
    //        然后依次退出返回克隆结点），最终会把所有相连的结点全部克隆；
    public Node dfs(Node root, HashMap<Node,Node> map){
        // 如果访问的结点为空，直接返回空；
        if(root == null) return null;
        // 如果递归的结点已经克隆过了，就直接返回存在 map 中该结点的克隆结点；
        if(map.containsKey(root)) return map.get(root);
        // 没有克隆过就克隆结点；
        Node clone = new Node(root.val,new ArrayList<>());
        // 克隆结点后先加入 map ，因为是无向图，防止进入死循环，不提前加入map,两个相连的结点就会一直循环递归，出不来；
        map.put(root,clone);
        // 深度递归，相邻链表中的每一个结点；
        for(Node neighborsNode : root.neighbors){
            clone.neighbors.add(dfs(neighborsNode,map));
        }
        // 每一层递归返回的都是克隆的结点；
        return clone;
    }
}
