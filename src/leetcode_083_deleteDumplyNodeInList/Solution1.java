package leetcode_083_deleteDumplyNodeInList;

//  题目: 删除排序链表中的重复元素;
//  描述: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
//示例 1:
//        输入: 1->1->2
//        输出: 1->2

public class Solution1 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
}
