package leetcode_012_intConversRoma;

//   题目: 整数转罗马数字;
//   描述: 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//       例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。
//              27 写做  XXVII, 即为 XX + V + II 。
//
//       通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
//        例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
//             同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//           I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//           X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
//           C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//  给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
//
//  示例 1:
//         输入: 3
//          输出: "III"

//    思路:  贪心算法;

public class Solution1 {
    public String intToRoman(int num) {
        // 将对应的数 和 罗马数字分别存在两个数组对应的位置;
        int[] array = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        // 新建字符串缓冲串, 保存转换结果;
        StringBuilder res = new StringBuilder();
        // 遍历数字;
        //  核心思想: 从高位开始,看当前数字 num 是否大于最高位表示的数,大于等于,就用当前数num除以最高位代表的数;
        //            得到的结果表示最高位数对应的罗马数字有几个,for循环添加进res;
        //              更新 num, 去掉高位, 依次遍历,直到 num == 0;
        for(int i = 0;i < array.length;i++){
            if(num >= array[i]){
                int m = num/array[i];
                for(int j = 0; j < m;j++) res.append(s[i]);
                num = num%array[i];
            }
        }
        return res.toString();
    }
}
