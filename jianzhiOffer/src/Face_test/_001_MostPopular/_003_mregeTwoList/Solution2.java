package Face_test._001_MostPopular._003_mregeTwoList;

//    思路二：
//         递归；

public class Solution2 {
    public class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here\
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = null;
        if(l1.val > l2.val){
            dummy = l2;
            l2.next = mergeTwoLists(l2.next,l1);
        }else{
            dummy = l1;
            l1.next = mergeTwoLists(l1.next,l2);
        }
        return dummy;
    }
}
