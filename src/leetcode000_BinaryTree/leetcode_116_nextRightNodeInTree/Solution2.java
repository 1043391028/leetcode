package leetcode000_BinaryTree.leetcode_116_nextRightNodeInTree;

//   Dfs(逐渐遍历每个结点的右节点)相当于从根节点的左子结点找右孩子到底和右子结点找左孩子结点一直到最后一层连接;
//       效率比方法3高;

public class Solution2 {
    public Node connect(Node root){
        dfs(root);
        return root;
    }

    public void dfs(Node root){
        if(root == null) return ;
//        暂时保存左子结点和右子节点，然后分别依次深度遍历每一层左子树最右边结点和右子树最左边结点；
        Node left  = root.left;
        Node right = root.right;
//        此while()循环，是把当前根节点的左子树每一层最右边的结点和左子树每一层最左边结点连接；
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
//        再遍历根结点的左子树和右子树
        dfs(root.left);
        dfs(root.right);
    }
}