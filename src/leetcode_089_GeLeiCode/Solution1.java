package leetcode_089_GeLeiCode;

//  题目: 格雷编码;
//  描述: 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//
//        给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
//
//        格雷编码序列必须以 0 开头。
//示例 1:
//         输入: 2
//         输出: [0,1,3,2]
//  解释:
//         00 - 0
//         01 - 1
//         11 - 3
//         10 - 2
//
//  思路: 对于 n 位数格雷编码, 只需要在 n-1 位数格雷编码的基础上修改,然后添加到结果链表;
//         具体修改规则: 倒序遍历 n-1 位数格雷码队列, 然后在每个数二进制位前加1 即可;
//            因存在结果链表中的数据都是十进制, 可转换为: num + carry(1右移n位)

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        // n == 0 , 将0 添加进去;
        res.add(0);
        // 从 n = 1 开始依次求n = 1,2,3...,n 的格雷码;
        int carry = 1;
        for(int i = 0;i<n;i++){
            for(int j= res.size()-1;j>=0;j--){
                res.add(res.get(j) + carry);
            }
            // 每循环一轮, carry右移一位;第一轮 1 第一位;
            carry <<=1;
        }
        return res;
    }
}
