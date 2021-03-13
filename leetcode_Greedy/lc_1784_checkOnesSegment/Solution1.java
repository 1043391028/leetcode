package lc_1784_checkOnesSegment;

// 题目： 检查二进制字符段；
//  描述： 给你一个二进制字符串 s ，该字符串 不含前导零 。
//
//         如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
//示例 1：
//       输入：s = "1001"
//       输出：false
//       解释：字符串中的 1 没有形成一个连续字段。
//
//  思路： 此题意图：判断是否只有一个连续为1的字符串；

public class Solution1 {
    public boolean checkOnesSegment(String s) {
        int len = s.length();
        int count = 0, start = 0,end = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i) == '1'){
                if(count == 0) start = i;
                end = i;
                count++;
            }
        }
        return count == end-start+1;
    }
}
