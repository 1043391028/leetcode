package leetcode_145_PostorderBinaryTree;

//  思路三： 模板法；（适合 中序的迭代法）
//    注意前序的迭代实际上很简单，不需要用这种模板；（代码在后面附上）

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null, p = root;
        while(!st.isEmpty() || p != null){
            if(p != null){
                st.push(p);
                p = p.left;
            }else{
                p = st.peek(); // 先取出元素，并不是弹出栈，需要判断；
                // 后续遍历和中序遍历的不同点，后续遍历多了一步判断；中序的话直接添加栈顶元素，然后让p = p.next；
                if(p.right == null || p.right == pre){
                    res.add(p.val);
                    pre = p;
                    st.pop();
                    p = null; // 注意，不能少；否则进入死循环；
                }else{
                    p = p.right;
                }
            }
            // 中序遍历秩序再在 else 里面改代码；
            //     不用 pre 结点，
            //  else{
            //          p = st.pop();
            //          res.add(p.val);
            //          p = p.right;
            //      }

        }
        return res;
    }
}

//  前序遍历的迭代法：
//     class Solution {
//public:
//    vector<int> preorderTraversal(TreeNode* root) {
//        stack<TreeNode> st = new stack<>();
//        List<Integer> result = new ArrayList<>();
//        st.push(root);
//        while (!st.empty()) {
//            TreeNode node = st.pop();                       // 中
//            result.add(node.val);
//            if (node->right) st.push(node->right);           // 右（空节点不入栈）
//            if (node->left) st.push(node->left);             // 左（空节点不入栈）
//        }
//        return result;
//    }
//}
