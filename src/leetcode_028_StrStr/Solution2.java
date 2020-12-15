package leetcode_028_StrStr;

//  思路二： 利用库函数，暴力匹配；时间复杂度和思路一一样
//           (但最终库利用函数效率很高，也不用判断边界条件)
//

public class Solution2 {
    public int strStr(String haystack, String needle){
        int hlen = haystack.length(), nlen = needle.length();
        for(int i =0; i < hlen - nlen +1;i++){
            if(haystack.substring(i,i+nlen).equals(needle)) return i;
        }
        return -1;
    }
}
