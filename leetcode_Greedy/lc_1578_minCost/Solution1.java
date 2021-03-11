package lc_1578_minCost;

//  题目： 避免重复字母的最小删除成本；
//  描述： 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
//
//          返回使字符串任意相邻两个字母不相同的最小删除成本。
//
//           请注意，删除一个字符后，删除其他字符的成本不会改变。
//
//示例 1：
//        输入：s = "abaac", cost = [1,2,3,4,5]
//        输出：3
//        解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）
//
//  核心思路：
//           遍历字符串字母， 如果两相邻字母相同，则判断大小，将小的加进结果；

public class Solution1 {
    public int minCost(String s, int[] cost) {
        int len  = s.length();
        int res = 0;
        for(int i = 1;i<len;i++){
            if(s.charAt(i) == s.charAt(i-1)){
                if(cost[i] < cost[i-1]){
                    res +=cost[i];
                    cost[i] = cost[i-1];
                }else{
                    res +=cost[i-1];
                }
            }
        }
        return res;
    }
}
