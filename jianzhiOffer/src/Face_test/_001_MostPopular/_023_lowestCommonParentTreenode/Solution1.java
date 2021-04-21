package src.Face_test._001_MostPopular._023_lowestCommonParentTreenode;

//  题目： 最近公共父结点；
//  描述： 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。

//  思路一： 递归；

public class Solution1 {
    public class TreeNode {
       int val = 0;
       TreeNode left = null;
       TreeNode right = null;
    }
    //  递归思路：
    //           相当不断往左右子节点去遍历，每遍历到一个结点就判断当前结点是否是 o1,o2其中一个；
    //               是的话就返回该节点的值，不是继续往下遍历直到叶子结点没找到就返回-1；
    //                  如果在中途某个结点左右子结点都返回不是-1；说明该节点下面包含 o1,o2结点；
    //
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root == null) return -1;
        if(root.val == o1 || root.val == o2) return root.val;
        // 看左子树里面是否有结点o1,o2;
        int left = lowestCommonAncestor(root.left,o1,o2);
        // 看右子树是否有目标节点 o1,o2;
        int right = lowestCommonAncestor(root.right,o1,o2);
        //  left == -1 说明左树没有目标结点，肯定在右树；
        if(left == -1) return right;
        // 同上
        if(right == -1) return left;
        // 如果左右都不等于-1， 说明当前结点左右为目标数；
        return root.val;

    }
}
