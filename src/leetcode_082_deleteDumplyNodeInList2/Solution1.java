package leetcode_082_deleteDumplyNodeInList2;

//   题目: 删除排序链表中的重复元素II;
//   描述: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//         输入: 1->2->3->3->4->4->5
//         输出: 1->2->5
// 思路一:
//          遍历各结点,cur 表示当前结点,
//            如果 cur 后两个结点相同,进入循环,新建一个临时结点temp;
//                 temp 一直往后遍历, 到最后一个;
//                   然后把 cur下一个结点置为 temp 的下一个结点; (cur.next = temp.next);
//            否则(后两个结点值不同), 就 cur = cur.next;

public class Solution1 {
        public class ListNode {
           int val;
           ListNode next;
           ListNode(int x) { val = x; }
        }

        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode dump = new ListNode(0);
            dump.next = head;

            ListNode cur = dump;
            while(cur.next != null && cur.next.next != null){
                if(cur.next.val == cur.next.next.val){
                    ListNode temp = cur.next;
                    while(temp.next !=null && temp.next.val == temp.val){
                        temp = temp.next;
                    }
                    cur.next = temp.next;
                }else{
                    cur = cur.next;
                }
            }
            return dump.next;
        }
}
