package src.Face_test._002_NC._070_SortList;

//  题目： 单链表排序；
//   描述：
//        给定一个无序单链表，实现单链表的排序(按升序排序)。

//   思路一： 归并；

 class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
 }

public class Solution1 {
    public ListNode sortInList (ListNode head) {
        if(head == null || head.next == null) return head;
        //  找到中间结点；
        ListNode fast = head.next,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 将链表分成两端并且记录链表头；
        ListNode node = slow.next;
        slow.next = null;
        ListNode right = sortInList(node);
        ListNode left = sortInList(head);
        return merge(left,right);
//         ListNode dummy = new ListNode(0), pre = dummy;
//         while(right!=null && left != null){
//             if(left.val < right.val){
//                 pre.next = left;
//                 left = left.next;
//             }else{
//                 pre.next = right;
//                 right = right.next;
//             }
//             pre = pre.next;
//         }
//         pre.next = left == null?right:left;
//         return dummy.next;
    }
    //  合并链表；
    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(0), pre = dummy;
        while(right!=null && left != null){
            if(left.val < right.val){
                pre.next = left;
                left = left.next;
            }else{
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left == null?right:left;
        return dummy.next;
    }
}
