package leetcode_137_SingleNumII;

//  思路二：
//          位与；
//        将nums 数组中每一个数每一位与 1-32 位1 与运算；统计所有数1-32位中1的位数cnt；
//           查找不重复的数设为 res, 则统计res二进制位上的数字1 即可确定该数字；
//             cnt 即代表每一位1的个数，cnt%3 == 1 则把该数字统计进该位；否则设置为0；
//                   最后得到的结果就是该数；

public class Solution2 {
    public int singleNumber(int[] nums) {
        int res = 0, index = 1;
        for(int i=0;i<32;i++){
            index = 1<<i;
            int cnt = 0;
            for(int num:nums){
                if( (num & index) != 0){
                    cnt++;
                }
            }
            if(cnt%3 == 1){
                res |= index;
            }
        }
        return res;
    }
}
