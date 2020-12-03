package leetcode_300_longestRiseSublist;

//  动态规划 + 二分（时间复杂度：o(NlogN)）

public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int maxLong = 0;
        // dp数组保存的是一个递增数列；dp[i]表示第 i 个位置上最小的结尾元素（在随着数组遍历不断更新）；
        int[] dp =new int[nums.length];
        for(int num:nums){
            int low =0, high = maxLong;
            // 二分法找第一个 dp[i]< num <=dp[i+1]的位置并替换dp[i];
            while(low < high) {
                int mid = (low + high) >>> 1;
                if (num > dp[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
                dp[low] = num;
                if (low == maxLong) {
                    maxLong++;
                }
            }
        }
        return maxLong;
    }
}
