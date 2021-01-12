package leetcode_191_NumsOfBinaryNum;

//  思路二： 从mask == 1 (表示第一位1) 低位依次与 n 做 & 运算,如果结果不为0，说明该位为 1 ；
//             mask 左移一位，继续与 n 做 & 运算，循环 32 次；

public class Solution2 {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for(int i = 0;i < 32; i++)
        {
            if((n&mask) != 0){
                count++;
            }
            mask <<=1;
        }
        return count;
    }
}
