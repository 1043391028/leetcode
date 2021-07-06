package src.Face_test._002_NC._051_mergeKSortedLists;

//   题目： 合并K个排序链表；
//   描述： 合并\ k k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度

//   思路一： 归并排序；

import java.util.ArrayList;

public class Solution1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null ||lists.size() == 0) return null;
        int len = lists.size();
        //  末尾位置一定是len-1不能是len；
        return help(lists,0,len-1);
    }
    public ListNode help(ArrayList<ListNode> lists,int start,int end){
//         if(start > end) return null;
        if(start == end) return lists.get(start);
        int mid = start + (end-start)/2;
        // 注意递归的开始和结束；
        ListNode left = help(lists,start,mid);
        ListNode right = help(lists,mid+1,end);
        return merge(left,right);
    }
    public ListNode merge(ListNode left,ListNode right){
        if(left == null || right == null)
            return left == null?right:left;
        //  以下部分可以用递归实现；
        ListNode dummy = new ListNode(0),cur = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                //cur = cur.next;
                left = left.next;
            }else{
                cur.next = right;
                //cur = cur.next;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null?right:left;
        return dummy.next;

//        递归实现代码
//        if(left.val < right.val){
//            left.next = merge(left.next,right);
//            return left;
//        }else{
//            right.next = merge(left,right.next);
//            return right;
//        }
    }
}
