package lc_392_isSubSequence;

// 思路二： 库函数 String.indexOf(char ch,int index) 返回 index 位置后第一个出现ch 的位置 ；（效率高）

import java.util.Arrays;

public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char ch:s.toCharArray()){
            index = t.indexOf(ch,index+1);
            if(index == -1) return false;
        }
        return true;
    }
}
