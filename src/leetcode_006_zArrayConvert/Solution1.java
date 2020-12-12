package leetcode_006_zArrayConvert;

//   题目： Z字形变换；
//   描述： 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//           比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//           L   C   I   R
//           E T O E S I I G
//           E   D   H   N
//           之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

//    思路：  1. 建立 numsRow（给定行数）个空缓冲字符串，保存到链表；
//           2. 遍历字符串 s 依次将字母添加到链表字符缓冲串中： 具体添加规则如下：
//               从第一个串到最后一个顺序，然后再从最后一个到第一个倒序依次添加；
//           3.最后从前往后遍历链表，将字符串添加到结果缓冲串中；

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public String convert(String s, int numRows) {
        // 判空；和 numsRow <2 的情况；
        if(s == null || s.length() == 0 || numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for(int i=0;i < numRows;i++){
            list.add(new StringBuilder());
        }
        // index 保存链表序号（保证遍历次序）； flag决定移动方向；
        int index = 0, flag = -1;
        // 遍历；
        for(int i = 0;i<s.length();i++){
            list.get(index).append(s.charAt(i));
            // 当 index 为第一个和最后一个缓冲串时反方向移动；
            if(index == 0|| index == numRows-1){
                flag = -1*flag;
            }
            index += flag;
        }
//        保存结果串；
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < numRows;i++){
            res.append(list.get(i));
        }
        return res.toString();
    }
}
