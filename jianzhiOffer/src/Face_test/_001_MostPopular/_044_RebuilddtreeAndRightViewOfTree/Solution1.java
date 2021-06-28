package src.Face_test._001_MostPopular._044_RebuilddtreeAndRightViewOfTree;

//  题目 : 根据先序和中序数组重建二叉树并输出树的右视图；


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Solution1 {
    // 树结点
    class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    // 主函数：广度遍历；
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode root = buildeTree(xianxu,zhongxu);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if(i == size-1) res.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        int[] ans = new int[res.size()];
        int index = 0;
        for(int num:res){
            ans[index++] = num;
        }
        return ans;
    }
    //  重构二叉树；
    public TreeNode buildeTree(int[] pre,int[] in){
        if(pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0;i<in.length;i++){
            if(in[i] == pre[0]){
                root.left = buildeTree(Arrays.copyOfRange(pre,1,1+i),Arrays.copyOfRange(in,0,i));
                root.right = buildeTree(Arrays.copyOfRange(pre,1+i,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }
}
