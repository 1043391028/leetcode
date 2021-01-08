package leetcode_145_PostorderBinaryTree;

//  题目： 二叉树的后序遍历；
//  描述： 给定一个二叉树，返回它的 后序 遍历。
//  进阶: 递归算法很简单，你可以通过迭代算法完成吗？

//  思路一： 递归遍历；（略）
//  思路二： 迭代遍历；
//           借助栈，将树结点按照 根->右节点->左节点添加进栈，依次遍历栈顶元素，当栈顶元素满足以下两个条件之一的把值加入进list,
//            把该结点的子节点加入栈顶（先加右节点），并把该节点弹出栈；

//  思路三： 核心思路；利用Arraylist,将栈里面元素依次加到队首；
//             这要求进栈是有一定约束，根->左->右；根加入list,然后出栈，出栈时把左节点加入，右节点加入；
//                然后再将栈顶元素(根节点的右节点)加入list的第一个位置,栈顶元的子节点入栈（先左->后右）弹出栈顶元素；
//                   这样保证了每一次都是按照 根->右->左顺序加入队列首部；，

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res ;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode pre = null;
        while(!st.isEmpty()){
            TreeNode node = st.peek();
            //本思路的关键；
            //  1.左右结点为空说明该结点没有前结点，而且此结点时栈顶结点（目前树最左下方的结点，可以出栈加入结果链表res）
            //  2. 前结点不为空，而且前结点是当前栈顶结点的儿子结点，说明子节点还没入栈（将子结点进栈，找当前树未入栈最左下结点）
            if( (node.left == null && node.right == null) || (pre != null && (pre == node.left || pre == node.right)))
            {
                res.add(node.val);
                pre = node;
                st.pop();
            } else{
                // 先加右结点，后加左节点；这样才能保证左节点先加入链表；
                if(node.right != null) st.push(node.right);
                if(node.left != null) st.push(node.left);
            }
        }
        return res;
    }
}
