package src.Face_test._001_MostPopular._033_mergeKSortedList;

// //  题目： 合并K个排序的链表；
////  描述： 合并 k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
////  思路一：
////         分治；
////  思路二：
////         优先队列（小顶堆）-> 根据结点的值；
////         将最小的结点出队列，出队时，如果下个结点不为空，将下一个结点加入队列；
//            依次循环，直到队列为空；

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution1 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        if(lists.size() == 0) return lists.get(0);
        return PartionMerge(lists,0,lists.size()-1);
    }
    // 分；
    public ListNode PartionMerge(List<ListNode> lists, int start, int end){
        //  start == end 只剩一个，直接返回其中一个；
        if(start == end) return lists.get(start);
        if(start > end) return null;
        int mid = start + (end-start)/2;
        ListNode left = PartionMerge(lists,0,mid);
        ListNode right = PartionMerge(lists,mid+1,end);
        return merge(left,right);
    }
    //    合；
    public ListNode merge(ListNode left,ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        if(left.val < right.val){
            left.next = merge(left.next,right);
            return left;
        }else{
            right.next = merge(left,right.next);
            return right;
        }
    }
}
