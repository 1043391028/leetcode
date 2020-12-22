package leetcode_092_ReverseList2;

//  题目: 反转链表II;
/// 描述: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
//  说明:
//        1 ≤ m ≤ n ≤ 链表长度。
//  示例:
//        输入: 1->2->3->4->5->NULL, m = 2, n = 4
//        输出: 1->4->3->2->5->NULL
//

public class Solution1 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = head, end = head, start = null;
        for(int i=1;i<m-1;i++){
            pre = pre.next;
        }
        for(int j = 1;j<n;j++){
            end = end.next;
        }
        ListNode temp = end.next;
        end.next = null;

        start = pre.next;
        pre.next = reverse(start);
        start.next = temp;
        return head;
    }
    public ListNode reverse(ListNode start){
        ListNode cur = start;
        ListNode pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
