package leetcode_02_SumOfReverseListnode;

//   题目： 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
//          并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//          您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        思路：此题注意点：（返回的链表也是逆序）
//                       进位和当前位的添加；
//                        链表头返回的结点；
//                        最后进位的添加；

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null){
            int a = l1 == null? 0 : l1.val;
            int b = l2 == null? 0 : l2.val;
            int now = a + b + carry;
            carry = now > 9? 1 : 0;
            now = now % 10;

            cur.next = new ListNode(now);
            cur = cur.next;

            if(l1 != null)  l1 = l1.next; // 这里注意，需要判断当前结点而不是下一个节点，判断下一个节点则没法通过（超时）；
            if(l2 != null)  l2 = l2.next;

        }
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
