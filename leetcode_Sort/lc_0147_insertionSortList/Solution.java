package lc_0147_insertionSortList;

//  题目:  对链表进行插入排序。

//    描述: 示例 1：
//         输入: 4->2->1->3
//         输出: 1->2->3->4

//   思路：
//         需要一个指针指向当前已排序的最后一个位置，这里用的是head指针
//         需 要另外一个指针pre,每次从表头循环，这里用的是dummy表头指针。
//        每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
//         如果前驱小，则进入内层循环，依次和pre指针比较，插入对应位置即可。

public class Solution {
    // 链表结点
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    // 插入排序
    public ListNode insertionSortList(ListNode head) {
        // 判空和一个结点情况
        if(head == null || head.next == null) return head;
        // 设置哑结点 dummy 保存头结点（用于返回）, pre结点保存头结点（用于每次循环遍历查找插入点）
        ListNode dummy = new ListNode(0),pre;
        dummy.next = head;
        // 头结点和头结点的下一个结点不为空时 判断；
        while(head != null && head.next != null)
        {
            // head 结点保存的是排好序链表的最后一个结点，判断和下一个结点大小；
            //   直到前一个结点大于后一个节点，出循环的时候，head指向的结点下一个结点就是我们要重新插入的结点；
            if(head.next.val > head.val){
                head = head.next;
                continue;
            }
            // 每次都要把 pre 指向头结点
            pre =  dummy;
            // 利用 pre找到插入点（pre下一个结点 > head.next结点）
            while(pre.next.val < head.next.val) pre = pre.next;
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }

}
