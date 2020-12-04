package leetcode_337_robInTree;

//  题目：打家劫舍3；（在二叉树中）
//  描述: 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
//        计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
//  思路一: 递归;

public class Solution1 {
    public int rob(TreeNode root) {
        // 结果数组(每个结点都有);保存递归返回结果;数组空间大小为 2 res[0]代表该结点不偷,res[1]代表偷;
        int[] res;
        res = robDfs(root);
        // 返回以该结点偷或者不偷的较大值
        // (已经包含此节点以下所有情况,即返回的就是最大值,因为下面每一层每一个结点都是返回的该结点最大结果;);
        return Math.max(res[0],res[1]);
    }
    public int[] robDfs(TreeNode root){
        // 结点为空,停止递归,返回空数组;
        if(root ==null) return new int[2];
        // 新建大小为 2 数组
        int[] res = new int[2];
        // 新建两个数组,保存左右结点返回结果数组; 用于最后选择当前结点最大值的不同情况;
        int[] left;
        int[] right;
        left = robDfs(root.left);
        right = robDfs(root.right);
        // 两种情况;res[0] 当前结点不偷,res[1] 当前结点偷;
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
