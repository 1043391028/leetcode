package leetcode_148_sortLIst;

//   题目: 排序链表;

//         给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
//   进阶：
//         你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

//   思路:  核心：遍历保存过程中 临时最大值 imax（表示到目前更新的最大值，可能是从中间的某一个值开始，因为中间可能会出现负数和0，
//                                             这样就得把之前的最大值丢掉，从后面继续算）
//          imin值保存最小值，因为很可能最大值碰到 负值后就变成了最小值，但是还不能丢弃，因为如果出现负值就可能变成最大值；


//    注意:思路简单,但是很多细节(代码中标注)

public class Solution1 {
    public ListNode sortList(ListNode head) {
//        只剩一个节点或者结点为空就返回该节点即可
        if(head == null || head.next == null) return head;
        //  快慢指针,找出中间结点;
        ListNode slow = head , fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
//      开始分支, 把中间结点的下一个结点作为右分支的头结点;
        ListNode Rhead = slow.next;
        slow.next = null; // 这里一定要置空中间结点下一个结点(即从中间把链表断开成两个)
        // 往下分成两个链表递归; 但是一定要保存返回的结点,因为下面要合并
        // 这里注意不能直接用 head 和 Rhead ,因为经历递归函数后就变了;
        ListNode left = sortList(head);
        ListNode right = sortList(Rhead);

        return merge(left,right);
    }

    public ListNode merge(ListNode Lhead,ListNode Rhead){
        // 合并这里,注意,新建一个头结点(返回),和一个临时头结点(遍历连接下面的结点)
        ListNode Head = new ListNode(0);
        ListNode tempHead = Head;
        while(Lhead != null && Rhead != null){
            if(Lhead.val > Rhead.val){
                tempHead.next = Rhead;
                Rhead = Rhead.next;
            }else{
                tempHead.next = Lhead;
                Lhead = Lhead.next;
            }
            tempHead = tempHead.next;
        }
        tempHead.next = Lhead == null? Rhead : Lhead;
        return Head.next;
    }

}
