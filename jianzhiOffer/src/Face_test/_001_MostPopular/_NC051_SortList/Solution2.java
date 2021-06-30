package src.Face_test._001_MostPopular._NC051_SortList;

//  思路二： 归并排序；

public class Solution2 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null) return head;
        ListNode fast = head.next,slow = head;
        //  循环条件一定要有 fast != null,否则会报空指针异常；
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 保存右半边结点的头（递归入口）
        ListNode node = slow.next;
        // 断开连接；
        slow.next = null;
        ListNode right = sortInList(node);
        ListNode left = sortInList(head);
        ListNode dummy = new ListNode(0), pre = dummy;
        while(right!=null && left != null){
            if(left.val < right.val){
                pre.next = left;
                left = left.next;
            }else{
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left == null?right:left;
        return dummy.next;
    }
}
