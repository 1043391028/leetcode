package leetcode_017_letterOfPhoneNumber;

//  题目：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

//    思路：递归加回溯

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
//      电话号码键数字对应的字母映射
//      这里也可以用map，用数组可以更节省点内存
    String[] str_map = {"","*","abc","def","ghi","jklm","nop","qrst","uvw","xyz"};
    public List<String> letterCombinations(String digits){
//         判空和字符不存在情况；
        if(digits == null || digits.length() == 0) return new ArrayList<>();
//        递归调用函数；new StringBuild() 为了临时存储递归中拼接的字符串，然后添加到结果链表中；
        resultStr(digits,new StringBuilder(),0);
        return res;
    }
    List<String> res = new ArrayList<>();

//   递归函数主体

    void resultStr(String digits, StringBuilder letter,int index){
//         首先判断递归出口；index（下标）= didits.length时说明最后一个字符已经添加完毕，
//         (其实此时已经把字符串 digits对应的最后一个数字对应的字符添加进letter去了）。
//           接着需要把缓冲串 letter 加入到结果 字符串链表 res 中；
        if(index == digits.length()) {
            res.add(letter.toString());
            return ;
        }

//        获取 index 对应的字母映射，然后遍历添加；

        char c = digits.charAt(index);
        int num = c - '0';
        String str = str_map[num];

//       遍历字符串，添加到缓存字符串 letter 中；下面给出第一次循环过程，以字符“234” 为例；
//         实际上只是遍历了第一个数字 2 对应的字母，因为时递归，index 代表的下标在不断改变，就可以逐渐向下遍历；
//
        for(int i = 0 ; i < str.length() ; i++){
//            进入该层，如此时为 数字键2 对应的字母'a' ,首先把该字母加入到缓冲串 letter 中
            letter.append(str.charAt(i));
//            接着向下递归调用，添加另外字母对应的字母；
            resultStr(digits,letter,index + 1);
//            出该层需要把该字母出缓冲串，即字母'a' 出串，
            letter.deleteCharAt(letter.length()-1);
//            接下来接着遍历数字键 2 对应的字母 'b';
        }

    }

// letter.append(map_string.charAt(i));
}
