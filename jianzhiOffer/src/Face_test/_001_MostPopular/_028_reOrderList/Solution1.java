package src.Face_test._001_MostPopular._028_reOrderList;

//  题目： 重排链表；
//  描述:  要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
//  例如：
//         对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.

///  思路一：
//            1.找到中间结点，分成两部分；
//            2.将后半部分反转；
//            3.然后将后半部分和前半部分连接；
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}

public class Solution1 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        // 快慢结点找中间结点；
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // cur 反转后半部分代表当前结点，pre 代表前结点；
        ListNode cur = slow.next, pre = null;
        // 需要将前半部分和后半部分分开；
        slow.next = null;
        // 反转；
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // l1,l2 分别代表前后两部分的头结点；
        ListNode l1 = head,l2 = pre;
        while(l1 != null && l2 != null){
            ListNode temp1 = l1.next, temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }
}
