package leetcode_00BinaryTree.leetcode_116_nextRightNodeInTree;

//    题目： 填充每个节点的下一个右侧节点指针
//           给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//            struct Node {
//                            int val;
//                            Node *left;
//                            Node *right;
//                            Node *next;
//                        }
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
//初始状态下，所有 next 指针都被设置为 NULL。

//        思路：递归；(相当于一层一层遍历)
//
public class Solution1 {
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        dfs(curr.left, curr.right);
//        把相邻的结点也递归遍历下去
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }
}
