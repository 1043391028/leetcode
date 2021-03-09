package lc_0767_ReOrganizeString;

// 题目： 重构字符串；
// 描述:  给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//
//        若可行，输出任意可行的结果。若不可行，返回空字符串。
//
//示例 1:
//       输入: S = "aab"
//       输出: "aba"
//
//    思路一： 贪心 + 大顶堆；

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    public String reorganizeString(String S) {
        // 判断长度；
        if(S == null || S.length() < 2) return S;
        int len = S.length();
        int[] charCount= new int[26];
        int maxCount = 0;
        // 将字母个数统计到数组中；并保留最多字母个数
        for(int i = 0;i < len;i++){
            charCount[S.charAt(i)-'a']++;
            maxCount = Math.max(maxCount,charCount[S.charAt(i)-'a']);
        }
        // 如果最多字母数 > 一半，那么不满足条件，必会出现相邻字母相同；
        if(maxCount > (len+1)/2) return "";
        // 构造大顶堆
        PriorityQueue<Character> queue = new PriorityQueue(new Comparator<Character>(){
            public int compare(Character char1,Character char2){
                return charCount[char2-'a']-charCount[char1-'a'];
            }
        });
        // 将S字符串中字母压入大顶堆；此时最多的字母在上面；
        for(char ch ='a';ch <= 'z';ch++){
            if(charCount[ch-'a'] > 0) queue.add(ch);
        }
        // 依次将顶部两个字母poll()出堆；并判断出堆后该字母是否为 0，不为0则需要重新将字母压入堆中；
        // 循环条件是 queue > 1;每次出堆两个元素，则最后可能会剩余元素，最后需要判断；

        // 注意： 不需要担心最后出来的元素和前一个相同，因为，剩两个的元素一定会早出来；
        StringBuilder sb = new StringBuilder();
        while(queue.size() > 1){
            char ch1 = queue.poll();
            char ch2 = queue.poll();
            sb.append(ch1);
            sb.append(ch2);
            charCount[ch1-'a']--;
            charCount[ch2-'a']--;
            if(charCount[ch1-'a'] > 0) queue.add(ch1);
            if(charCount[ch2-'a'] > 0) queue.add(ch2);
        }
        if(queue.size()>0) sb.append(queue.poll());

        return sb.toString();

    }
}
