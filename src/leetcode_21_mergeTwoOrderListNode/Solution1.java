package leetcode_21_mergeTwoOrderListNode;

//      题目：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

//        递归方法：

public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        判空；
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
//      调用递归；
        return merge(l1,l2);
    }
//     递归函数；
    ListNode  merge(ListNode node1,ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        if(node1.val < node2.val) {
            node1.next = merge(node1.next,node2);
            return node1;
        }
        else {
            node2.next = merge(node1,node2.next);
            return node2;
        }
    }

}

//     递归简略版；
//      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if(l1 == null) {
//            return l2;
//        }
//        if(l2 == null) {
//            return l1;
//        }
//
//        if(l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
