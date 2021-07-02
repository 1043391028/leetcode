package src.Face_test._002_NC._053_DeleteReverseNnode;

//  题目： 删除倒数第N个结点；
//  描述： 给定一个链表，删除链表的倒数第 nn 个节点并返回链表的头指针
//  例如，
//       给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
//       删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
//备注：
//      题目保证 nn 一定是有效的
//      请给出请给出时间复杂度为\ O(n) O(n) 的算法

//  思路一：三个结点，cur 代表前结点，pre代表删除的结点，dummy代表删除节点的前一个结点；

public class Solution1 {
    public class ListNode {
      int val;
      ListNode next = null;
      ListNode(int val){
          this.val = val;
      }
    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode dummy = new ListNode(0),pre= head,cur = head;
        dummy.next = head;
        for(int i = 1;i<n;i++){
            cur = cur.next;
        }
        while(cur.next != null){
            dummy = dummy.next;
            pre = pre.next;
            cur = cur.next;
        }
        //  需要判断删除的是否为第一个结点；
        if(pre == head){
            head = head.next;
        }
        dummy.next = pre.next;
        pre.next = null;
        return head;
    }
}
