package leetcode_23_mergeKLists;

//       分治解法

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0) return null;
//     调用分支函数
        return merge(lists, 0, lists.length - 1);
    }

    ListNode merge(ListNode[] lists,int start,int end){
        if(start == end) return lists[start];
        int mid = start + (end - start)/2 ;
        ListNode l1 = merge(lists,start,mid);
        ListNode l2 = merge(lists,mid+1,end);

        return mergeTwolists(l1,l2);
    }

    ListNode mergeTwolists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwolists(l1.next,l2);
            return l1;
        }
        l2.next = mergeTwolists(l1,l2.next);
        return l2;
    }
}
