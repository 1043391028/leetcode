package leetcode_171_ExcelArrayNum;

//  题目：excel表格序号；
//  描述： 给定一个Excel表格中的列名称，返回其相应的列序号。
//
//  例如，
//       A -> 1
//       B -> 2
//       C -> 3
//        ...
//       Z -> 26
//       AA -> 27
//       AB -> 28
//       ...
//
//  思路一： 新建一个大小为26的数组，分别从小到大存1-26（对应A-Z）
//             遍历 s 字符串，每个字符 ch-'A'可表示下标；

public class Solution1 {
    public int titleToNumber(String s) {
        // 新建数组，保存对应数 1 - 26；
        int[] nums = new int[26];
        for(int i =0;i<26;i++){
            nums[i] = i+1;
        }
        // 遍历字符串每个字符，并计算结果；
        //   字符对应的 数组下标为 s.charAt(i) - 'A'
        int len = s.length();
        int sum = 0;
        for(int i = 0;i<len;i++){
            int temp = nums[s.charAt(i)-'A'];
            sum = sum*26 + temp;
        }
        return sum;
    }
}

//  精简写法：
//              public int titleToNumber(String s) {
//                  int ans = 0;
//                  for(int i=0;i<s.length();i++) {
//                        int num = s.charAt(i) - 'A' + 1;
//                        ans = ans * 26 + num;
//                  }
//                 return ans;
//              }
//
