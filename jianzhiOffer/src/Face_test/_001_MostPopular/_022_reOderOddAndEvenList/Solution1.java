package src.Face_test._001_MostPopular._022_reOderOddAndEvenList;

//  题目： 奇偶链表重排；
//  描述： 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
//         注意是节点的编号而非节点的数值。
//
//  思路：
//       建立奇偶结点的头结点，遍历结点链表，一次将奇偶结点连接；
//         最后将偶结点头部连接到奇数结点的尾部；

public class Solution1 {
    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
  }

    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head == null || head.next == null || head.next.next == null) return head;
        // 哑结点，返回；
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 遍历链表过程代表奇数结点的 odd（不断后移）
        ListNode odd = head;
        // 建立一个偶数结点头部（保持不动）
        ListNode evenHead = head.next;
        // 遍历链表过程遍历偶数结点的 even（不断后移）
        ListNode even = head.next;
        // 以偶数结点下个结尾为标志（偶数结点在后面）
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        // 最后将偶数结点的头连接到 最后一个奇数结点后面
        odd.next = evenHead;
        return dummy.next;
    }
}
