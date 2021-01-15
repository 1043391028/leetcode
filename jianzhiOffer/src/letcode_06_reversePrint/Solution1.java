package letcode_06_reversePrint;

//  题目： 从尾到头打印链表；
//  描述： 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//  示例 1：
//         输入：head = [1,3,2]
//         输出：[2,3,1]
//  思路一：
//         递归；
//              时间复杂度： o(n);
//              空间复杂度： o(n);
//  思路二： 借助辅助栈Stack；（实际上递归就是栈，系统栈）
//                 二者时间复杂度和空间复杂度一样；

//   注意：推荐看下面的优化空间版（在递归的时候记录结点数，最后结点为空时，构建数组）；

public class Solution1 {
    private int[] res;
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        res = new int[count];
        reverse(head);
        return res;
    }
    private int index = 0;
    private void reverse(ListNode head){
        if(head == null) return ;
        reverse(head.next);
        res[index++] = head.val;
    }
}

// 优化空间：
///public class Solution1 {
//    private int[] res;
//    public int[] reversePrint(ListNode head) {
//        reverse(head);
//        return res;
//    }
//    private int index = 0;
//    private void reverse(ListNode head){
//         在这里初始化空间；
//        if(head == null) {
//             res = new int[count];
//             return ;
//        }
//        count++； // 计算一共多少非空结点，可表示最终数组大小；
//        reverse(head.next);
//        res[index++] = head.val;
//    }
//}
