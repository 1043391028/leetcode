package leetcode_125_IsHuiwenList;

//  题目： 验证回文串；
//  描述: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//  说明：本题中，我们将空字符串定义为有效的回文串。
//
//示例 1:
//        输入: "A man, a plan, a canal: Panama"
//        输出: true
//
//  知识点： 判断字符串中字符是否是字母或者数字的库函数： Character.isLetterOrDigit(ch);
//              转换为大小写库函数： s.toLowerCase(); s.toUpperCase();
//                  字符串转数组: s.toCharArray();
//                   StringBuilder sb 转换为字符串 sb.toString();

public class Soution1 {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() ==0) return true;
        // 所有字母转小写；
        s = s.toLowerCase();
        // 去除除字母数字外的其他符号；
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if((ch >= '0' && ch <= '9') || (ch>='a' && ch <='z'))
                sb.append(ch);
        }
        // 再转换为字符串；
        String str = sb.toString();
        // 也可转换为数组：
        //  char[] chars = sb.toString().toCharArray();
        // 验证是否时回文串；
        int i = 0,j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
