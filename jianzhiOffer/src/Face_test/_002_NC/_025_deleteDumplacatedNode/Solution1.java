package src.Face_test._002_NC._025_deleteDumplacatedNode;

//  题目: 删除重复结点;
//   描述:  删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
//   例如：
//       给出的链表为 1->1->2,返回 1→2.
//       给出的链表为 1→1→2→3→3,返回 1→2→3.
//   思路:
//          遍历删除;

public class Solution1 {

    public class ListNode {
      int val;
      ListNode next = null;
    }

    public ListNode deleteDuplicates (ListNode head) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
        ListNode cur = head;
        while(cur != null){
            //  注意判断非空;
            if(cur.next != null && cur.val == cur.next.val){
                int temp = cur.val;
                ListNode node = cur;
                //  内循环找到最后一个和头结点cur值不同的结点
                while(node != null && node.val == temp){
                    node = node.next;
                }
                // 连接头结点和第一个不同的结点;
                cur.next = node;
            }
            //  结点后移;
            cur = cur.next;
        }
        return head;
    }
}
