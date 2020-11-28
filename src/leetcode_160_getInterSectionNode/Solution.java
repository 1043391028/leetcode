package leetcode_160_getInterSectionNode;

public class Solution {
//    if (headA == null || headB == null) return null;
//    ListNode pA = headA, pB = headB;
//    while (pA != pB) {
//        pA = pA == null ? headB : pA.next;
//        pB = pB == null ? headA : pB.next;
//    }
//    return pA;

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) return null;
    ListNode rootA = headA , rootB = headB;
    while(rootA != rootB){
        // if(rootA.next == null) rootA = headB;
        // else rootA = rootA.next;
        // if(rootB.next == null) rootB = headA;
        // else rootB = rootB.next;
//       下面一定要注意,二目表达式判定条件是 rootA == null
//        而不是 rootA.next == null;否则会进入死循环(把链表连成一个圈);
        rootA = rootA.next == null? headB:rootA.next;
        rootB = rootB.next == null? headA:rootA.next;
    }
    return rootA;
}
}
