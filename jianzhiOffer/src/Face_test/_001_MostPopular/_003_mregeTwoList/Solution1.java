package Face_test._001_MostPopular._003_mregeTwoList;

//  题目： 合并两个有序链表；
//  描述：
//       将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
//  思路一：
//          依次遍历对比；

public class Solution1 {
    public class ListNode {
    int val;
    ListNode next = null;
    }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // 建立哑结点，为了最后返回头结点；
        ListNode dummy = new ListNode();
        // pre前结点，用来连接新的结点（小的）
        ListNode pre = dummy;
        while(l1 != null && l2 != null){
            if(l1.val>l2.val){
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }else{
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            }
        }
        pre.next = l1 == null?l2:l1;
        return dummy.next;
    }
}
