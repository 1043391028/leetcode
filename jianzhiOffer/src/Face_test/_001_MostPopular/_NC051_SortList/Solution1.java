package src.Face_test._001_MostPopular._NC051_SortList;

//  题目： 单链表排序；
//  描述： 给定一个无序单链表，实现单链表的排序(按升序排序)。
//       示例1
//             输入：
//             [1,3,2,4,5]
//             返回值：
//             {1,2,3,4,5}

//   思路一： 优先队列；（超时）
//    思路二：归并排序；

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
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
        //  创建优先队列（节点值小的放在队顶）：小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode cur = head;
        while(cur != null){
            queue.add(cur);
            cur = cur.next;
        }

        ListNode temp = new ListNode(0),dummy = temp;
        while(!queue.isEmpty()){
            temp.next = queue.poll();
            temp = temp.next;
        }
        return dummy.next;
    }
}
