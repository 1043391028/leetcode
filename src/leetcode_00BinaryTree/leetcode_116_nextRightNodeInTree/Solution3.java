package leetcode_00BinaryTree.leetcode_116_nextRightNodeInTree;

//   思路三：递归实现：一层一层的遍历；（比较好理解）

public class Solution3 {
    public Node connect(Node root) {
        if(root == null) return null;
        help(root.left,root.right);
        return root;
    }
    public void help(Node left,Node right){
        // 有一个为空就直接返回；
        if(left == null || right == null) return ;
        //两者都不为空，直接把两者相连；
        left.next = right;
        //依次遍历两个结点的子结点
        help(left.left,left.right);
        help(right.left,right.right);
        // 还要连接二者挨着的结点
        help(left.right,right.left);
    }
}
