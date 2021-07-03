package src.Face_test._002_NC._021_ReverseBetweenMandN;

//  题目： 反转指定区间内链表；
//   描述： 将一个链表\ m m 位置到\ n n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
//   例如：
//        给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, m=2,n=4m=2,n=4,
//                 返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
//   注意：
//        给出的 mm,nn 满足以下条件：
//         1 \leq m \leq n \leq 链表长度1≤m≤n≤链表长度

public class Solution1 {
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        for(int i = 1;i<m;i++){
            pre = pre.next;
        }
        ListNode next,cur = pre.next;
        for(int i = m;i<n;i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
