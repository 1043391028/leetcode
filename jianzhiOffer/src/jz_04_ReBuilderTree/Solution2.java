package jz_04_ReBuilderTree;

//  思路二：利用数组切割 + 递归；

import java.util.Arrays;

public class Solution2 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0 || in.length==0){
            return null;
        }
        TreeNode root =new TreeNode(pre[0]);
        for (int i=0;i<pre.length;i++){
            if(in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                // break;
            }
        }
        return root;

    }
}
