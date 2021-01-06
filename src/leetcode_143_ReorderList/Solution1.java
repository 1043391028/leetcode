package leetcode_143_ReorderList;

//   题目： 重排链表；
//   描述： 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//         将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//          你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
// 示例 1:
//          给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//
//    思路一： 递归；
//             除去头结点和尾结点，把中间一部分堪称递归整体；
//               中间递归整体返回的是外层的尾结点；(具体递归规则代码中介绍)
//                 用外层头结点连接尾结点outtail，尾结点outtail指向中间部分的头结点subhead；
public class Solution1 {
    // 结点；
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 主函数；
    public void reorderList(ListNode head) {
        if(head == null) return ;
        ListNode temp = head;
        int cnt = 1;
        while(temp.next != null){
            cnt++;
            temp = temp.next;
        }
        helpOrder(head,cnt);
    }
    // 递归函数；count代表以head开头还有几个结点；
    public ListNode helpOrder(ListNode head,int count){
        // 如果还剩一个结点，那么外层的尾结点就是 head.next;
        //   返回该节点，并且置空该节点（设置为尾结点）；
        if(count == 1){
            ListNode outtail = head.next;
            head.next = null;
            return outtail;
        }
        // 如果剩两个结点，那么外层尾结点就是 head.next.next;
        //   同样暂存到outtail结点返回，并置该节点为空；
        if(count == 2){
            ListNode outtail = head.next.next;
            head.next.next = null;
            return outtail;
        }
        // 外层尾结点接收；此时在该层中间看成一个整体；
        ListNode outtail = helpOrder(head.next,count-2);
        // subhead 保存中间头结点,后面需要将外层尾结点outtail指向该节点；
        ListNode subhead = head.next;
        // 外层头结点指向外层尾结点；
        head.next = outtail;
        // 暂存当前层的外层尾结点；最后返回到上一层；
        ListNode curOuttail = outtail.next;
        // 当前层尾结点指向中间头结点；
        outtail.next = subhead;
        return curOuttail;
    }

}
