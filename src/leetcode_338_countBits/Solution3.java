package leetcode_338_countBits;

//  思路3: dp + 最低有效位;
//         状态转移方程:
//          P(x)= P(x/2) + (xmod2)(代表最低位,其实除以2就相当于把最后一位给抹去了)
//

public class Solution3 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
}
