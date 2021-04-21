package src.Face_test._001_MostPopular._024_durgeHuiwen;

// 题目： 判断回文子串；
// 描述： 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
// 示例1
//      输入
//          "absba"
//      返回： true;

//  思路一：中间向两边遍历
//          判断字母个数奇偶，然后借助辅助函数判断；
public class Solution1 {
    public boolean judge (String str) {
        // write code here
        int len = str.length();
        int mid = len/2;
        // 奇数个 左右都从mid 开始遍历；
        if(len%2 == 1){
            return durge(str,mid,mid);
        }
        return durge(str,mid-1,mid);
    }
 //    辅助函数；l:中间向左遍历的位置，r : 中间向右遍历的位置；
    public boolean durge(String s,int l,int r){
        while(l>=0){
            if(s.charAt(l) != s.charAt(r)) return false;
            l--;
            r++;
        }
        return true;
    }
}
