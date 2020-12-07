package leetcode000_BinaryTree._leetcode_098_isBinaryTree;

//      题目：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//           假设一个二叉搜索树具有如下特征：
//
//           节点的左子树只包含小于当前节点的数。
//           节点的右子树只包含大于当前节点的数。
//            所有左子树和右子树自身必须也是二叉搜索树。

//      思路：中序遍历，每次遍历用 pre保留上个结点的值，下次比较，如果当前结点值小于pre结点值就不符合；

public class Solution1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
   // 初始化前一个值为最小；
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
          if(root == null) return true;
//        先遍历比较左结点；
          if(!isValidBST(root.left)){
              return false;
          }
//        判断主体，比较并保留上一个结点值；
          if(root.val <= pre){
              return false;
          }
          pre = root.val;
//       最后返回遍历右结点的结果；（最后一个遍历的为最右结点）
          return isValidBST(root.right);
    }
}
