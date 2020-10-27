package leetcode_03_lengthOfLongestSubstring;

public class Solution2 {
    //      解法2：  也是双指针

        public int lengthOfLongestSubstring(String s){
            int[] num = new int[128];
            int len = s.length();
            int start = 0 ;
            int max = 0;
            for(int i = 0 ;i < len ;i++){
                int index = s.charAt(i);
                start = Math.max(start , num[index] + 1); // num[index] ,只要index 为新字符，不会影响start改变
//                                                          只有index 为重复字符时，start 位置移动到重复字符下一个；
                max = Math.max(max , i - start + 1);
                num[index] = i;  // 每次循环更新当前字符位置为 i ，为了使下次碰到该字符比较
            }
            return max;
        }
}
