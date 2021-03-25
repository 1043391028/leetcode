package leetcode004_BinarySearch.lc_23_mergeKLists;

// 题目： 给你一个链表数组，每个链表都已经按升序排列。
//
//        请你将所有链表合并到一个升序链表中，返回合并后的链表。
//示例 1：
//        输入：lists = [[1,4,5],[1,3,4],[2,6]]
//        输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//                   [
//                     1->4->5,
//                     1->3->4,
//                     2->6
//                   ]
//     将它们合并到一个有序链表中得到。
//           1->1->2->3->4->4->5->6
//
//  思路：  分治排序链表；

import java.util.PriorityQueue;

public class Solution1 {
    //  将数组依次分成两个数组，直到数组个数 <= 2(三种情况返回结果);
    public ListNode mergeKLists(ListNode[] lists){
        // 三种情况（递归出口）
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return merge(lists[0],lists[1]);
        //  依次将数组分成两个一组，最后归并；先分（分数组）后合（merge,按照大小）
        int len = lists.length;
        int mid = len/2;
        ListNode[] l1 = new ListNode[mid],l2 = new ListNode[len-mid];
        for(int i = 0;i<len;i++){
            l1[i] = lists[i];
        }
        for(int i = mid;i<len;i++){
            l2[i-mid] = lists[i];
        }
        return merge(mergeKLists(l1),mergeKLists(l2));
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode root = null;
        if(l1.val > l2.val){
            root = l2;
            root.next = merge(l1,l2.next);
        }else {
            root = l1;
            root.next = merge(l1.next, l2);
        }
        return root;
    }
}
