package leetcode_060_getAllSortedArray;

//  题目: 排序序列;
//  描述: 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
//  按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//               "123"
//               "132"
//               "213"
//               "231"
//               "312"
//               "321"
//  给定 n 和 k，返回第 k 个排列。

// 示例 1：
//           输入：n = 3, k = 3
//           输出："213"
//
//    思路:  dfs(此题只有递归,没有回溯,剪枝掉)
import java.util.Arrays;

public class Solution1 {
    // 定义全局变量,为了使dfs函数参数简单,使主函数参数 n,k 不用作为参数传如 dfs 函数;
    private int n;
    private int k;
    private boolean[] used;
    private int[] jc;
   // 主函数;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n+1];
        Arrays.fill(used,false);
        jiecheng(n);
        // 保存结果的缓冲字符串;
        StringBuilder path = new StringBuilder();
        dfs(0,path);
        return path.toString();
    }
    // 递归; index 表示在进入该层循环一共添加了多少数字;
    //  当 StringBuilder 保存添加的字符;
    public void dfs(int index,StringBuilder sb){
        // 如果 index = n , 说明已经添加 n 个数字了;直接返回;
        if(index == n){
            return ;
        }
        // cnt 计算当前层 选择某数字后剩下数字可组成的情况;如果 < k 说明该层数字不能选, 选择新的数字;
        int cnt = jc[n-index-1];
        for(int i = 1;i <= n;i++){
            if(used[i]) continue;
            // 如果 cnt < k 选择新的数字(剪枝), 但是选择新的数字需要把 k值更新,
            //  k = k-cnt(减去当前数字所有的情况,相当于跳过)
            if(cnt < k){
                k -=cnt;
                continue;// 选择新的数字;
            }
            // 该层递归选择一合适的数字添加进缓冲串(结果串sb)
            sb.append(i);
            // 使用过的数子需要标记,防止下次递归再次使用;
            used[i] = true;
            dfs(index + 1,sb);
            // 这里不用回溯,因为递归到底(index == n) 肯定找到了结果,递归完直接返回;;
            return ;
        }
    }
    // 阶乘函数更新 jc[n] 数组(保存 0-n 对应的阶乘数,全排列组合数)
    public void jiecheng(int n){
        jc = new int[n+1];
        jc[0] = 1;
        for(int i = 1;i <= n;i++){
            jc[i] = jc[i-1]*i;
        }
    }
}
