package leetcode_145_PostorderBinaryTree;

// 思路三： 核心思路；利用Arraylist,将栈顶元素依次加到队首；
//             这要求进栈是有一定约束，根->左->右；
//                首先，根加入list,然后出栈，出栈时把左节点加入，右节点加入；
//                   然后，再将栈顶元素(根节点的右节点)加入list的第一个位置,栈顶元的子节点入栈（先左->后右），
//                      最后，弹出栈顶元素；
//                   一直这样弹栈入栈，直到栈空；
//                这样保证了每一次都是按照 根->右->左顺序加入队列首部；，

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res ;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode pre = null;
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            res.add(0,node.val);
            if(node.left != null) st.push(node.left);
            if(node.right != null) st.push(node.right);
        }
        return res;
    }
}
