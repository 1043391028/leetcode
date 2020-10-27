package leetcode_144_preOderTree;

//       前序遍历树；

import java.util.LinkedList;
import java.util.List;


public class Solution {

    LinkedList<Integer> list = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return list;
        else{
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}
