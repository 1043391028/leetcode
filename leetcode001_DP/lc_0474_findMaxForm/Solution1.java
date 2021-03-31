package lc_0474_findMaxForm;

// 题目： 一和零；
//  描述： 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//        请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//
//         如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集
//示例 1：
//       输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//       输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//      其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"}
//      不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。

// 思路一： 转化为 0-1 背包问题；
//        可优化空间（优化为二维）；

public class Solution1 {
    //  转换为 0 - 1 背包问题：  m ,n 表示 装0 和 1 的背包容量；
      public int findMaxForm(String[] str,int m,int n){
          int len = str.length;
          int[][][] dp = new int[len+1][m+1][n+1];
          //  i 表示到 第i个字符串 的最大子集；
          //  j , k 表示容量；
          for(int i = 1;i<=len;i++){
              // 统计当前字符串的 0 ， 1 的个数；
              int[] count = countOneAndZero(str[i-1]);
              for(int j = 0;j<=m;j++){
                  for(int k =0;k<=n;k++){
                      // 先把之前的结果保存；
                      dp[i][j][k] = dp[i-1][j][k];
                      // 判断是否选择装当前字符串；
                      if(j>=count[0] && k >= count[1]){
                          // dp[i-1][j][k] : 当前字符没装就占满了 j，k空间的背包；
                          // dp[i-1][j-count[0]][k - count[1]]: 当前字符串装了才占用 j ,k 空间的背包；
                          dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-count[0]][k-count[1]] + 1);
                      }
                  }
              }
          }
          return dp[len][m][n];
      }

      public int[] countOneAndZero(String str){
          int len = str.length();
          int[] res = new int[2];
          for(int i =0;i< len;i++){
              res[str.charAt(i) - '0']++;
          }
          return res;
      }
}
