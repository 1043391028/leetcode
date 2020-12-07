package leetcode000_BinaryTree.leetcode_538_converseBST;

//  题目: 把二叉搜索树转换为累加树;(和1038题相同)
//  描述: 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
//        使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

//提醒一下，二叉搜索树满足下列约束条件：
//                                   节点的左子树仅包含键 小于 节点键的节点。
//                                   节点的右子树仅包含键 大于 节点键的节点。
//                                    左右子树也必须是二叉搜索树。
//
//   思路: 按照右->中->左 顺序遍历树,每次把前面结点和保存在整数preNum中,
//                  遍历当前结点时,再上当前结点,并保存在preNum中;

public class Solution1 {
    int preNum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        if(root.right != null){
            convertBST(root.right);
        }
        root.val += preNum;
        preNum = root.val;
        if(root.left != null){
            convertBST(root.left);
        }
        return root;
    }
//     简洁代码:
// class Solution {
//   int num = 0;
//
//    public TreeNode convertBST(TreeNode root) {
//        if (root != null) {
//            //遍历右子树
//            convertBST(root.right);
//            //遍历顶点
//            root.val = root.val + num;
//            num = root.val;
//            //遍历左子树
//            convertBST(root.left);
//            return root;
//        }
//        return null;
//    }
//}
}
