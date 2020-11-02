package leetcode_21_mergeTwoOrderListNode;

//        迭代法：
public class solution2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        新建一个头链表；用来最后返回；
        ListNode prehead = new ListNode(-1);
//       此结点是为了依次向下遍历，是移动的结点；
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
