package leetcode_117_ConnectNextRightNode;

//  题目：填充每个结点下一个右边结点指针；
//  描述： 给定一个二叉树
            //struct Node {
            //  int val;
            //  Node *left;
            //  Node *right;
            //  Node *next;
            //}
//        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

//        初始状态下，所有 next 指针都被设置为 NULL。
//  进阶：
//        你只能使用常量级额外空间。
//        使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
// 思路一：递归；
//         实际上就两种情况；1.左子是否为空；2，右子是否为空；
//            分别针对两种情况连接结点；
// 思路二： 双端队列；

public class Solution1 {
    public Node connect(Node root) {
        // 判断是否为空
        if(root == null) return null;
        // 左子空右子不空，
        if(root.left != null && root.right != null) root.left.next = root.right;
        // 左子不空 右子空
        if(root.left != null && root.right == null) root.left.next = deconnect(root.next);
        // 右子不空
        if(root.right != null) root.right.next = deconnect(root.next);
        //**** 下面千万注意递归顺序；
        //   先递归右子结点，将右半部分连接，因为左子节点的连接依赖右子节点；
        //   举例： 递归进入第三层（三个结点）两个结点在右子树，一个结点在左子树，其中右子树两个结点中左边哪个没有子节点，
        ///             而右子树右边结点有子节点，那么右边两个结点不先连接，左子树的结点后面就没法连接下一个结点；
        connect(root.right);
        connect(root.left);
        return root;
    }
    public Node deconnect(Node root){
        if(root == null) return null;
        if(root.left != null) return root.left;
        if(root.right != null) return root.right;
        return deconnect(root.next);
    }
}
