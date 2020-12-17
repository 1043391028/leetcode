package leetcode_061_SpinList;

//  题目: 旋转链表;
//  描述: 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//        输入: 1->2->3->4->5->NULL, k = 2
//        输出: 4->5->1->2->3->NULL
//  解释:
//        向右旋转 1 步: 5->1->2->3->4->NULL
//        向右旋转 2 步: 4->5->1->2->3->NULL
//
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//  思路:  1. 找到链表尾端tail ,然后把tail.next = head(形成环形链表);
//         2. 从环形链表重新找新的尾结点;
//          3. 将尾结点下一个结点置为头结点,并把尾结点下一个结点置空;

public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode old_tail = head;
        int n = 1;
        while(old_tail.next != null){
            n++;
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        // 找到新的尾结点, 也就相当于找到了新的头结点
        for(int i = 0;i< n-k%n-1;i++){
            head = head.next;
        }
        // 暂存新的尾结点的下一个结点(新的头结点)
        ListNode temp = head.next;
        // 新的尾结点下一个结点置空;
        head.next =null;
        // 新的头结点
        head = temp;
        // 返回新的头结点;
        return head;
    }
}
