package Face_test.detectCycle;

// 题目：   对于一个给定的链表，返回环的入口节点，如果没有环，返回null
//拓展：
//     你 能给出不利用额外空间的解法么？

import Face_test.String_test.reverseKGroup.ListNode;

public class Solution1 {
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    // 使用了额外空间；
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    ListNode newSlow = head;
                    ListNode newFast = fast;
                    while (newFast != newSlow) {
                        newFast = newFast.next;
                        newSlow = newSlow.next;
                    }
                    return newSlow;
                }
            }
            return null;
        }
        // 不使用额外空间；
    public ListNode detectCycle1(ListNode head){
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        if(fast == null || fast.next == null) return null;
        return slow;
    }
}

