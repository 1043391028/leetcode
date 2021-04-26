package src.Face_test._001_MostPopular._031_SumOfTwoList;

//  题目： 两个链表生成相加结果的和；
//   描述： 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
//           给定两个这种链表，请生成代表两个整数相加值的结果链表。
//   例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。

import java.util.LinkedList;

//  思路一：
//          借助双端链表；
//           1.先将两个链表的数依次保存到两个链表；
//           2.然后从顶部开始遍历相加；
//           3.得到的结果创建链表结点并利用头插法加入到链表；
//  思路二：
//           1.反转两个链表得到 l1,l2；
//           2.从链表头部遍历结点相加得到结果创建新结点，并加到尾部；
//           3.反转新建的链表；

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}

public class Solution1 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        LinkedList<Integer> l1 = new LinkedList<>() , l2 = new LinkedList<>();
        while(head1 != null || head2 != null){
            if(head1 != null){
                l1.add(head1.val);
                head1 = head1.next;
            }
            if(head2 != null){
                l2.add(head2.val);
                head2 = head2.next;
            }
        }
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        while(!l1.isEmpty() || !l2.isEmpty() || carry>0){
            int a = l1.isEmpty()?0:l1.pollLast();
            int b = l2.isEmpty()?0:l2.pollLast();
            int sum = a+b+carry;
            int num = sum%10;
            ListNode node = new ListNode(num);
            node.next = dummy.next;
            dummy.next = node;
            carry = sum/10;
        }
        return dummy.next;
    }
}
