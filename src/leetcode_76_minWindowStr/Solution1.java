package leetcode_76_minWindowStr;

//    题目：给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
//            如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//          注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

//     思路：滑动窗口；

import sun.security.util.Length;

public class Solution1 {
    public String minWindow(String s,String t){
//        判空；
          if(s == null || s.length() == 0 || t == null || t.length() ==0) return "";
//        初始化一个数组，保存 l 数组中字符个数；
          int[] need = new int[128];
          for(int i = 0;i < t.length();i++){
              need[t.charAt(i)]++;
          }
//        初始化参数；l、r 窗口左、右边界；start 记录中间过程裁剪 s 字符串的开头位置；
//        minSize 初始化为最大整数，为了最后判断是否在 s 中找到 l 的全部字符，如果未找到（遍历完count始终大于0）就没有更新；
//        count 记录在 s 中是否找到 l 对应的所有字符；
          int l = 0, r = 0 , start = 0, minSize = Integer.MAX_VALUE, count = t.length();
//        遍历 s 数组，当 r(右边界) < s.length 一直循环遍历；
          while(r < s.length()){
              char ch =s.charAt(r);
//              如果遍历的字符在 l 中存在，则count--（匹配一个字母） ; 右边界右移，（在最后），窗口扩大；
              if(need[ch] > 0){
                  count--;
              }
//              这里无论 ch 字符是否存在，均--；不存在就逐渐减小为负数；
              need[ch]--;
//            当 count == 0 时，说明窗口中已经含有所有 l 字符；需要排除左边一些 l 中不存在的字符（即那些need[ch]<0）；
//            达到缩小窗口，直到 l(左边界)字符 = 0；此时再缩小左边界就不满足 count == 0;
              if(count == 0){
                  while(l < r && need[s.charAt(l)] < 0){
                      need[s.charAt(l)]++;
                      l++;
                  }
//                检查更新最小窗口；
                  if(r- l + 1 < minSize){
                      minSize = r - l + 1;
                      start = l;
                  }
//                 此时更新到的左边界值为临界情况，即第一个 need[ch] 为0 的字符；一旦再右移，就count++；
                  need[s.charAt(l)]++;
                  l++;
                  count++;
              }
//        右边界右移，
              r++;
          }
          return minSize == Integer.MAX_VALUE ? "" : s.substring(start , start + minSize);
    }
}
