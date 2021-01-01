package leetcode_109_sortedListToBinaryTree;

//   题目: 有序链表转换为二叉搜索树;
//   描述: 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//         本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//    思路一:  递归;
//            可以将链表中结点转换为list中;然后在 list 中找中点作为root;
//              递归中间结点左边找左子树根节点, 右边找右子结点;
//                依次递归;


import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<ListNode> list = new ArrayList<>();
        int len = 0;
        while(head != null) {
            list.add(head);
            head = head.next;
            len++;
        }
        TreeNode root = new TreeNode();
        return buildTree(list,0,len-1);
    }
    public TreeNode buildTree(List<ListNode> list, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(list.get(start).val);
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = buildTree(list,start,mid-1);
        root.right = buildTree(list,mid+1,end);
        return root;
    }
}
