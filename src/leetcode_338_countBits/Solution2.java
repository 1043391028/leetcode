package leetcode_338_countBits;

//  思路二: 简单粗暴,利用一个计算二进制位'1'的函数;然后依次遍历 0 - num 之间的数,分别用函数计算;

public class Solution2 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i)
            ans[i] = popcount(i);
        return ans;
    }
    public int popcount(int num){
        int count = 0;
        while(num!=0){
            num &= num-1; // n & n-1 等于把 n 二进制位最右边的 1 消去;
            count++;
        }
        return count;
    }

}

//    其实可以直接用dp状态转移方式一次遍历;(具体如下:)
//      public int[] countBits(int num) {
//          int[] ans = new int[num + 1];
//          for (int i = 1; i <= num; ++i)
//           ans[i] = ans[i & (i - 1)] + 1;
//            return ans;
//      }
//
