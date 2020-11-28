package leetcode_206_reverseList;

//    题目: 反转一个单链表。
//
//   示例:
//         输入: 1->2->3->4->5->NULL
//         输出: 5->4->3->2->1->NULL
//         进阶:
//             你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
         if(head == null) return null;
         // 此题只是反转链表,不需要新建头结点,只需要新建一个临时结点;
         ListNode pre = null;
         //临时结点,保存下一个节点,因为要断裂当前结点,就要保存下一个;
         ListNode TempHead = head;
         ListNode temp = null;
         while(TempHead != null){
             temp = TempHead.next;
             TempHead.next = pre;
             // 依次向下移动结点
             pre = TempHead;
             TempHead = temp;
         }
         return TempHead;
    }
}
