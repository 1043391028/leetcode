package Face_test._001_MostPopular.TheKNumInList;

//  题目： 链表中倒数第K个结点；

import Face_test.String_test.reverseKGroup.ListNode;

public class Solution1 {

    public class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode first = pHead, second = pHead;
        // 将头结点向后移动k次；
        while(first != null && k>=1){
            first = first.next;
            k--;
        }
        // 如果k > 0 说明没有移动k次，链表长度<k;
        if(k>0) return null;
        // 继续移动前一个结点，后一个同时移动，当前一个结点到末尾，后一个结点正好是倒数第k个结点；
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
