package leetcode_00BinaryTree._leetcode_101_isSymmetricTree;

//     题目： 给定一个二叉树，检查它是否是镜像对称的。

//            如，二叉树 [1,2,2,3,4,4,3] 是对称的。

//     思路：递归遍历；依次对比；

public class Solution1 {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
//
    class Solution {
        public boolean isSymmetric(TreeNode root) {

            if(root == null) return true;
//            辅助函数返回结果；
            return dfs(root.left,root.right);
        }
//      递归函数；对比左右子树；三种情况；
        public boolean dfs(TreeNode left,TreeNode right){
//            情况一：两个结点为空，返回 true;
            if(right == null && left == null){
                return true;
            }
//            情况二：只右一个结点为空，返回 false;
            if(right == null || left == null){
                return false;
            }
//            情况三：值不相等，返回 flase;
            if(left.val != right.val){
                return false;
            }
//          如果当前节点值相等，接着遍历下一层结点；
            return dfs(left.left,right.right) && dfs(left.right,right.left);
        }
    }
}
