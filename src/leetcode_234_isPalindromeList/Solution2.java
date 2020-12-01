package leetcode_234_isPalindromeList;

//  思路二: 递归;
//大致思路: 递归到最后一个结点;然后回溯,每回溯一个和前面的对比(从前往后遍历的需要一个结点保存)

public class Solution2 {
    // 声明全局变量 ListNode,为了每次递归回溯比较;
    private ListNode pre;
    // 主判断函数
    public boolean isPalindrome(ListNode head){
        pre = head;
        return isPal(head);
    }
    // 递归函数
    public boolean isPal(ListNode head){
        if(head != null){
            // 一直递归到最后一个结点为空
            if(!isPal(head.next)){
                return false;
            }
            // 结点为空以后,回到倒数第一个不为空的,和第一个结点 pre 值比较;
            if(head.val != pre.val){
                return false;
            }
            // 前面结点值 pre 后移;
            pre = pre.next;
        }
        return true;
    }
}
