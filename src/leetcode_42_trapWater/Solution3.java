package leetcode_42_trapWater;

//      思路3：动态规划：
//            首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。（一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
//        时间复杂度：o(n)
//        空间复杂度：o（n）

public class Solution3 {
    public int trap(int[] height) {
        int sum = 0;
//        初始化下标为 ‘i’ 左右最大序列值为 0；
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
//      从前往后动态求 ‘i’ 左边最大值；
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
//       从后往前动态求 ‘i’ 右边做大序列值；
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
//         遍历数组，添加水（按照思路2 ， 按列添加水），
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
