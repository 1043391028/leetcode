package leetcode_00BinaryTree.leetcode_654_maxRootBinaryTree;

//     题目：给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//           二叉树的根是数组中的最大元素。
//            左子树是通过数组中最大值左边部分构造出的最大二叉树。
//            右子树是通过数组中最大值右边部分构造出的最大二叉树。
//            通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//      思路：递归；

public class Solution1 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return help(nums,0,nums.length-1);
    }

    public TreeNode help(int[] nums,int lo,int hi){
        if(lo > hi) return null;
//      遍历数组，保留最大值为根节点；
        int index = max(nums);
        TreeNode root = new TreeNode(nums[index]);
//        遍历左子结点和右子节点，依次保留最大值到左右结点；
        root.left = help(nums,lo,index - 1);
        root.right = help(nums,index + 1,hi);
        return root;
    }

    public int max(int[] nums){
        int max = Integer.MIN_VALUE,index = -1;
        for(int i=0; i < nums.length; i++){
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
