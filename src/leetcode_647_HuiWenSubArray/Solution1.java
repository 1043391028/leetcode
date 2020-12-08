package leetcode_647_HuiWenSubArray;

//  题目: 回文子串;
//  描述: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//示例 1：
//        输入："abc"
//        输出：3
//        解释：三个回文子串: "a", "b", "c"
//
//  思路:  双中心扩散法:
//         遍历数组,从中心元素开始对比,相等(说明以此为中心的字符串是回文串)就count++;然后左右边界各往两边扩散;
//         双中心: 因为有可能两个字母为中心往两边扩散依然是回文;

public class Solution1 {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] charArray = s.toCharArray();
        int len = charArray.length, count = 0;
        // i < len*2-1 (len*2-1个中心),分别是 len 个单字符和 len - 1 个双字符。
        for(int i = 0;i < len*2-1;i++){
            // 确定双中心开始位置;i为奇数,说明有偶数个元素(两个数为中心),i为偶数说明有奇数个元素(一个数为中心);
            int l = i/2;
            int r = l+ i%2 ;
            // 下面写法是错的
//            while(l>=0 && r < charArray.length){
//                if(charArray[l] == charArray[r]) count++;
//                l--;
//                r++;
//            }
            // 正确写法;
            while(l>= 0 && r<len && charArray[l] == charArray[r]){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
