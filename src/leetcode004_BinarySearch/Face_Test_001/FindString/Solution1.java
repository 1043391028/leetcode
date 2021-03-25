package leetcode004_BinarySearch.Face_Test_001.FindString;

//  题目： 稀疏数组搜索；
//   描述: 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。

//示例1:
//      输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
//      输出：-1
// 说明: 不存在返回-1
//
// 思路： 二分；

public class Solution1 {
    public int findString(String[] words, String s) {
        int len = words.length;
        int l = 0, r = len-1;
        //  这里 while用 l<=r,是因为在内循环里判断了是否存在目标字符串，如果 l<r,可能会漏掉最后一个元素判断；
        //   l <= r 则出循环就判断玩内部不存在了；
        while(l<=r){
            int mid = l + (r-l)/2;
            int temp = mid;
            while(mid >= l && words[mid].equals("")) mid--;
            if(words[mid].equals(s)) return mid;
            if(words[mid].compareTo(s) > 0){
                r = mid-1;
            }else{
                l = temp+1;
            }
        }
        return -1;
    }
}
