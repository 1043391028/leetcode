package leetcode_236_lowerstCommonAncester;

//  题目: 二叉树中最近公共祖先结点;
//  描述: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
//       满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//  思路: 递归;
// 大致思路:
//         1. 依次从根节点递归深度遍历二叉树,找到目标节点 p , q , 空结点或者不是就返回null;
//         2. 找到 p,q 就返回,往上回溯,直到某个结点左右孩子为 p,q.返回该节点;
// p,q分布有四种情况:
//                 实际上就是递归寻找目标结点(p,q),回溯传回到某个结点两边时代码中解释;
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // root == null,为空结点直接返回; root == p,q 返回root,
        // 然后回溯,(回溯的时候就不断的把该结点往上传,直到某个结点两边为p,q);
        if(root == null || root == p || root == q) return root;
        // 定义两个结点,接收回溯传回来的结点;为了判断是否为空(是否为p,q结点)
        TreeNode left,right;
        // 递归往下找 p,q 结点;
        left = lowestCommonAncestor(root.left,p,q);
        right = lowestCommonAncestor(root.right,p,q);
        // 判断,一边为空,就返回另一边;
        if(left == null) return right;
        if(right == null ) return left;
//         假如到某一个结点两边都不为空;说明此结点就是所求结点;
//        有可能该节点在左子树中(该节点返回,回溯到根节点),那么右子树肯定返回null(并且回溯到根节点,一直返回null),
//         最后返回左子树中的那个回溯回来的结点;
        return root;
    }
}
