package leetcode_108_sortedArrayToBst;

//   题目: 将有序数组转换为二叉搜索树;
//   描述: 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
//         本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//  思路一:
//          递归;
//          找根(数组中间点), 然后递归找左子树和右子树的根(数组左半边和右半边的中间值)

public class Sollotion1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return Helpsorted(nums,0,nums.length-1);
    }
    public TreeNode Helpsorted(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start+1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = Helpsorted(nums,start,mid-1);
        root.right = Helpsorted(nums,mid+1,end);
        return root;
    }
}
