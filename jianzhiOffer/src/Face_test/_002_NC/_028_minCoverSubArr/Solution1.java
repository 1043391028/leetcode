package src.Face_test._002_NC._028_minCoverSubArr;

//  题目： 最小覆盖子串；
//  描述：　给出两个字符串 SS 和 TT，要求在O(n)O(n)的时间复杂度内在 SS 中找出最短的包含 TT 中所有字符的子串。
//　例如：
//　　　　S ="XDOYEZODEYXNZ"S="XDOYEZODEYXNZ"
//　　　　T ="XYZ"T="XYZ"
//　　　　找出的最短子串为"YXNZ""YXNZ".
//注意：
//　　　　如果 SS 中没有包含 TT 中所有字符的子串，返回空字符串 “”；
//　　　　满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。

//　　　思路：滑动窗口；

public class Solution1 {

    public String minWindow (String S, String T) {
        // write code here
        int[] map = new int[128];
         // 统计目标字符串中字母个数；
        for(char ch:T.toCharArray()){
            map[ch]++;
        }
        // left,right窗口左右边界；count = T.length() - 窗口内目标字母个数；
        //  start 记录过程中不断更新最短字符串的开始位置，minLen记录最短长度字符；
        int left = 0,right = 0,count = T.length(),start = 0,minLen = Integer.MAX_VALUE;
        while(right < S.length()){
            // 字母个数>0才能count--，表示目标字符进入窗口；
            if(map[S.charAt(right)]-- >0){
                count--;
            }
            // 当窗口内包括所有目标字符（count==0）开始更新最短字符串；
            while(count == 0){
                if(minLen > right-left){
                    minLen = right-left;
                    start = left;
                }
                // 并压缩窗口，移动窗口左边界；
                if(map[S.charAt(left++)]++ ==0){
                    count++;
                }
            }
            right++;// 右移窗口
        }
        return minLen == Integer.MAX_VALUE?"":S.substring(start,start+minLen+1);
    }
}
