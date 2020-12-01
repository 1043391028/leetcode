package leetcode_234_isPalindromeList;

//  题目: 回文子串
//  描述: 请判断一个链表是否为回文链表。
//
//示例 1:
//       输入: 1->2
//       输出: false
//示例 2:
//       输入: 1->2->2->1
//       输出: true
// 进阶：
//      你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
//
//  思路一: 1. 找中间结点;
//         2. 反转中间节点后的链表;
//         3.两个开始指针(一头一尾),向中间依次对比结点;

public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        // 判空,一定要有,否则会出现空指针异常;
        if(head == null) return true;
        // 快慢指针找中间结点;
         ListNode slow = head , fast = head.next; // 这里令fast == head.next;最终找到的中间结点是偏右边(偶数个)的;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
         }
         // 反转后半部分链表;和反转链表思路一致;
         ListNode pre = null;
         while(slow != null){
             ListNode temp = slow.next;
             slow.next = pre;
             pre = slow;
             slow = temp;
         }
//       最后比较从两边,双指针(头尾);这里有个细节;假如链表个数为奇数个,那么后半部分链表会多一个,所以下面必须是'&&';
//         这样最后左半部分链表最后并没有遍历完,但是只要前面相等久能返回 true;(最后一个是中间元素)
         while(pre!= null && head != null){
             if(head.val != pre.val) return false;
             head = head.next;
             pre = pre.next;
         }
         return true;
    }
}
