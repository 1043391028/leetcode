package lc_1540_CanConvertString;

//  题目： K次操作转变字符串；
//         给你两个字符串 s 和 t ，你的目标是在 k 次操作以内把字符串 s 转变成 t 。
//
//         在第 i 次操作时（1 <= i <= k），你可以选择进行如下操作：
//
//          选择字符串 s 中满足 1 <= j <= s.length 且之前未被选过的任意下标 j （下标从 1 开始），并将此位置的字符切换 i 次。
//        不 进行任何操作。
//         切换 1 次字符的意思是用字母表中该字母的下一个字母替换它（字母表环状接起来，所以 'z' 切换后会变成 'a'）。
//
//      请记住任意一个下标 j 最多只能被操作 1 次。
//
//       如果在不超过 k 次操作内可以把字符串 s 转变成 t ，那么请你返回 true ，否则请你返回 false 。
//
//  核心思路：遍历字母，需要记录每个字母更换的次数；

public class Soluiton1 {
    public boolean canConvertString(String s, String t, int k) {
        int len = s.length();
        char[] strS = new char[len];
        char[] strT = new char[len];
        int[] num = new int[26];
        strS = s.toCharArray();
        strT = t.toCharArray();
        int res = 0;
        for(int i=0;i<len;i++){
            //  注意点： s字符串中i字母的位置 和 t字符串i位置的前后关系；
            int div = (strT[i] - strS[i] + 26)%26;
            // 同位置就不变；
            if(div == 0)  continue;
            // 将变换的次数+1(题目要求不能前后变换同次数)
            num[div]++;
            if(div + (div-1)*26 >k) return false;
        }
        return true;
    }
}
