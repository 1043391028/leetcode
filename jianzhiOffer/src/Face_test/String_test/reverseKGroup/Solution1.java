package Face_test.String_test.reverseKGroup;

// 题目：
//        将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
//        如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
//        你不能更改节点中的值，只能更改节点本身。
//        要求空间复杂度 \ O(1) O(1)
// 例如：
//        给定的链表是1\to2\to3\to4\to51→2→3→4→5
//        对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
//        对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5

public class Solution1 {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head == null || head.next == null || k <= 1) return head;
        ListNode dummy = new ListNode(0), pre = dummy, next,cur = head;
        dummy.next = head;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        // 这里采用头插法；
        for(int i = 0;i<len/k;i++){
            for(int j = 0;j<k-1;j++){
                // 画图理解；next 保存的是当前结点的下一个结点
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
