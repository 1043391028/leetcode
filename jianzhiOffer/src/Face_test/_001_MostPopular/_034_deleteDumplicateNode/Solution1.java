package src.Face_test._001_MostPopular._034_deleteDumplicateNode;

//  题目： 删除所有重复的结点；
//  描述： 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
//  例如：
//        给出的链表为1 \to 2\to 3\to 3\to 4\to 4\to51→2→3→3→4→4→5, 返回1\to 2\to51→2→5.
//        给出的链表为1\to1 \to 1\to 2 \to 31→1→1→2→3, 返回2\to 32→3.

public class Solution1 {
    public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
  }

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head , pre = dummy;
        while(cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                pre = pre.next;
            }else{
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 出循环 cur 指向最后一个重复的结点；
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
