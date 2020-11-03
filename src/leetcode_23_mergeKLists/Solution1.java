package leetcode_23_mergeKLists;

//      题目：   给你一个链表数组，每个链表都已经按升序排列。
//
//           请你将所有链表合并到一个升序链表中，返回合并后的链表。

//      思路1： 优先级队列；

import javax.swing.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0) return null;
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val) return -1;
//                else if (o1.val == o2.val) return 0;
//                else return 1;
//            }
//        });
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2)->o1.val - o2.val);

        ListNode head = new ListNode(0);
        ListNode curNode = head;
        for (ListNode node: lists) {
            if(node != null) queue.add(node);
        }

        while(!queue.isEmpty()){
            curNode.next = queue.poll();
            curNode = curNode.next;
            if(curNode.next != null) queue.add(curNode.next);
        }
        return head.next;
    }
//    ListNode dummy = new ListNode(0);
//        ListNode p = dummy;
//        for (ListNode node : lists) {
//            if (node != null) queue.add(node);
//        }
//        while (!queue.isEmpty()) {
//            p.next = queue.poll();
//            p = p.next;
//            if (p.next != null) queue.add(p.next);
//        }
//        return dummy.next;

}
