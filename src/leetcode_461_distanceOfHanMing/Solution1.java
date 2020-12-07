package leetcode_461_distanceOfHanMing;

//   题目: 汉明距离;
//   描述: 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
//         给出两个整数 x 和 y，计算它们之间的汉明距离。
//   注意：
//         0 ≤ x, y < 231.

public class Solution1 {
    public int hammingDistance(int x, int y) {
        int res = x^y , sum = 0;
        while(res != 0){
            if(res%2 == 1) sum++;
            res = res >> 1; // 消除结果 res 二进制位最后一位; n = n^(n-1) 可以消除二进制位最后一位 1;
        }
        return sum;
    }
}
