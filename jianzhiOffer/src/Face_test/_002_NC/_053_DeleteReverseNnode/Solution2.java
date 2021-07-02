package src.Face_test._002_NC._053_DeleteReverseNnode;


//  思路二：pre 代表删除结点的前结点；cur代表删除结点后的第N个结点；

public class Solution2 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // dummy保存返回结点的前结点；
        ListNode dummy = new ListNode(0),pre = dummy,cur = dummy;
        dummy.next = head;
        // cur结点往后移动N个；此时pre结点和cur结点相差N个结点；
        for(int i = 0;i<n;i++){
            cur = cur.next;
        }
        // 同时移动cur和pre结点，直到cur指向最后一个结点，此时pre指向删除结点的前一个结点；
        while(cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        // 将前一个结点指向下下个结点，但是删除结点并没有置空；
        pre.next = pre.next.next;
        //  将删除结点置空方法如下：
//        ListNode next = pre.next.next;
//        pre.next = null;
//        pre.next = next;
        return dummy.next;
    }
}
