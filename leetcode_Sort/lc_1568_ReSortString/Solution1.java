package lc_1568_ReSortString;

// 题目描述： 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
//
//        请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
//
//         返回重新排列后的字符串。
//
//  思路一：利用字符数组
//          依次将String s 中的字母从头到尾排列到字母本该的位置（依据indices[i]）

//   思路二： for循环遍历 i表示当前位置；
//              判断indices[i] == i ? 等于直接继续
//                  否则，先交换字母位置；同时交换数组中 indices[i] 和 indices[indeics[i]]两数的位置；

public class Solution1 {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        int len = indices.length;
        char[] chars = new char[len];
        for(int i= 0;i < len;i++ ){
            chars[indices[i]] = s.charAt(i);
        }
        // 返回新的字符串，利用得到的数组（已经按照顺序排好）转换；
        return new String(chars);
    }
}
