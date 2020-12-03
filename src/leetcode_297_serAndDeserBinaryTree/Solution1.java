package leetcode_297_serAndDeserBinaryTree;

//   题目：二叉树的序列化与反序列化；
//   描述： 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
//         请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

//   示例: 
//        你可以将以下二叉树：
//                             1
//                            / \
//                           2   3
//                              / \
//                             4   5
//
//        序列化为 "[1,2,3,null,null,4,5]"

//   思路1： Dfs(递归遍历)

import java.util.Arrays;
import java.util.LinkedList;

public class Solution1 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            ser_help(root,sb);
            return sb.toString();
        }
        // 序列化辅助函数；（前序遍历方式，也可后序、中序）
        public void ser_help(TreeNode root, StringBuilder sb){
            if(root == null){
                sb.append("null,");
                return ;
            }
            sb.append(root.val);
            sb.append(',');

            ser_help(root.left,sb);
            ser_help(root.right,sb);
        }
        // 反序列化；
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] array = data.split(",");
            LinkedList<String> deque = new LinkedList<>(Arrays.asList(array));
            TreeNode root = new TreeNode(0);
            return deser_help(deque);
        }
        // 反序列化辅助函数；（同样是前序添加结点）
        public TreeNode deser_help(LinkedList<String> deque){
            if(deque.get(0).equals("null")){
                deque.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(deque.get(0)));
            deque.remove(0);
            root.left = deser_help(deque);
            root.right = deser_help(deque);
            return root;
        }
        // 反序列另一种写法：
//        public TreeNode deserialize(String data) {
//            String[] temp = data.split(",");
//            Deque<String> dp = new LinkedList<>(Arrays.asList(temp));
//            return buildTree(dp);
//        }
//        private TreeNode buildTree(Deque<String> dq){
//            String s = dq.poll();  //返回当前结点
//            if (s.equals("X")) return null;
//            TreeNode node = new TreeNode(Integer.parseInt(s));
//            node.left = buildTree(dq); //构建左子树
//            node.right = buildTree(dq); //构建右子树
//            return node;
//        }
    }
}
