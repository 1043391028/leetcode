package leetcode_019_deleteListNodeNthFromEnd;

//  题目： 删除倒数第 N 个结点；
//  描述： 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//  示例：
//        给定一个链表: 1->2->3->4->5, 和 n = 2.
//          当删除了倒数第二个节点后，链表变为 1->2->3->5.
//  说明：
//        给定的 n 保证是有效的。
//  进阶：
//        你能尝试使用一趟扫描实现吗？
//  思路：  双指针：

public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null ) return null;
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(i<n){
            fast = fast.next;
            i++;
        }
        // 新建头结点pre(用于返回结果)
        //  新建辅助结点temp,保存移除结点的前一个节点；
        ListNode pre = new ListNode(0);
        pre.next = slow;
        ListNode temp = pre;
        while(fast != null){
            fast= fast.next;
            temp = slow;
            slow = slow.next;
        }
        // 找到删除结点 slow 并直接将其前结点temp的next置为slow的下一个结点；
        temp.next = slow.next;
        return pre.next;
    }
}
