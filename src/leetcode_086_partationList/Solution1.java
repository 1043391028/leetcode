package leetcode_086_partationList;

//  题目: 分割链表;
//  描述: 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//        你应当保留两个分区中每个节点的初始相对位置。
//  示例:
//        输入: head = 1->4->3->2->5->2, x = 3
//        输出: 1->2->2->4->3->5
//  思路: 双链表;
//         遍历原链表,依次将 <x 和 >=x 的node结点加入两个链表,然后将两个链表连接;

public class Solution1 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        // 需要初始化两个头结点,用来最后 连接和返回 新链表;
        ListNode pre = new ListNode(0);
        ListNode curPre = pre; // 新链表头结点的上一个结点;
        ListNode tail = new ListNode(0);
        ListNode curTail = tail; // 最后连接两个链表
        while(head != null){
            if(head.val < x){
                curPre.next = head;
                head = head.next;
                curPre = curPre.next;
            }else{
                curTail.next = head;
                head = head.next;
                curTail = curTail.next;
            }
        }
        // 这里一定要将后半边链表(>=x 部分)最后结点下一个结点置空, 否则可能会出现循环链表;
        curTail.next = null;
        // 将前半边链表的尾和后半边的头连接;
        curPre.next = tail.next;
        return pre.next;
    }

}
