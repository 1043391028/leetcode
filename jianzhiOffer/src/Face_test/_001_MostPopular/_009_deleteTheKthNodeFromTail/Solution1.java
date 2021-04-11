package Face_test._001_MostPopular._009_deleteTheKthNodeFromTail;

//  题目： 删除链表中倒数第 k 个元素，并返回头结点；

//   思路一： 双指针；

public class Solution1 {
    public class ListNode {
    int val;
    ListNode next = null;
  }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy; // 保存删除结点的前一个结点；
        ListNode first = head; //  第一个结点；
        ListNode second = head; // 第二个结点;
        for(int i = 0;i<n;i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            pre = second;
            second = second.next;
        }
        // 最后连接删除结点的前置结点和后置结点；
        pre.next = second.next;
        second.next = null;
        return dummy.next;
    }
}
