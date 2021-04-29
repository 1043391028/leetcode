package src.Face_test._001_MostPopular._039_isHuiwenList;

//  题目： 判断是否是回文链表；
//   描述: 给定一个链表，请判断该链表是否为回文结构。

//  思路一：
//          1.找中点，然后分成两部分；
//          2.后半部分反转；
//          3.依次对比两个链表结点；

public class Solution1 {
    public class ListNode {
    int val;
    ListNode next = null;
  }

    public boolean isPail (ListNode head) {
        // write code here
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        slow.next = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        ListNode reverse = pre;
        while(reverse != null && head != null){
            if(head.val != reverse.val) return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
}
