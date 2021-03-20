package lc_1463_isValidateBinaryTreeNode;

//  题目： 验证二叉树结点；
//  描述： 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
//
//         只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
//
//            如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
//
//注意：节点没有值，本问题中仅仅使用节点编号。
//
//  思路一：(经验证，此方法不行)
//         验证入度为 1 的结点数 和入度超过 1 的结点数（此法通不过多个树的情况）

public class Solution1 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] in = new int[n];
        for(int i = 0;i<n;i++){
            if(leftChild[i] != -1) in[leftChild[i]]++;
            if(rightChild[i] != -1) in[rightChild[i]]++;
        }
        int count0 = 0, count1 = 0;
        for(int i=0;i<n;i++){
            if(in[i] == 0) count0++;
            if(in[i] > 1) count1++;
        }
        return count0 == 1 && count1 == 0;
    }
}
