package leetcode_120_minNumInTriangle;

//  题目: 三角形最小路径和;
//  描述: 给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
//        每一步只能移动到下一行中相邻的结点上。
//
//        相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

//  示例 1：
//         输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//         输出：11
//         解释：自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//   思路: dp
//           自己的思路,这里并不是最优方案(写法可以简单,空间可以优化)
//            dp[i][j]表示第 i 行第 j 个元素的位置到"三角形"底端最小和;
//              初始化最后一行dp[len][j]为最后一行元素;依次往上一行一行求dp数组,
//                 转移方程dp[i][j] == num[i-1][j-1] +Min(dp[i][j],dp[i][j+1]);
//                   直到最后求dp[1][1];
//          此方法dp数组定义好理解,但是浪费掉第一行空间,且需要初始化;
//
//  简化代码思路:
//               直接dp[i][j] 表示下标 i,j 对应的元素位置到底边的最小元素和;
//                 这样不用初始化最后一行, dp[len-1][j] = num[len-1][j] + Min(dp[len][j],dp[len][j+1];
//                       这样默认dp[len][j](最后一行) = 0, 那么dp[len-1][j] 也就对应最后一行元素的值了;

//  空间优化思路:
//                求当前行的dp[j] 只和上一行dp[j]和dp[j+1]有关 所以直接利用循环n(外list长度)次;
//                  每层循环 dp[j] = num[i][j]+ Min(dp[j],dp[j+1]);

import java.util.List;

public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int len = triangle.size();
        int[][] dp = new int[len+1][len+1];
        for(int i=1;i <= len;i++){
            dp[len][i] = triangle.get(len-1).get(i-1);
        }
        for(int i = len-1;i > 0;i--){
            for(int j = 1;j<=i;j++){
                dp[i][j] = triangle.get(i-1).get(j-1) + Math.min(dp[i+1][j-1],dp[i+1][j]);
            }
        }
        return dp[1][1];
    }
}
