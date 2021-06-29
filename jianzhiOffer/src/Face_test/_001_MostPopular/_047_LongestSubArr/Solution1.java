package src.Face_test._001_MostPopular._047_LongestSubArr;

//  题目: 最长子序列；
//  描述： 给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
//  示例1
//       输入：
//            [100,4,200,1,3,2]
//     返回值：
//             4

//   思路一： HashSet;
//            1. 遍历数组将所有的数加入到set集合（同时过滤掉重复的元素）
//            2. 再次遍历数组，判断当前数的前一个是否在，存在在就继续循环，不在则判断后面相邻元素的个数；
//            3. 每次循环后更新最大值；

import java.util.HashSet;

public class Solution1 {
    public int MLS (int[] arr) {
        // write code here
        //  res保留总的最大个数，count保留每次循环当前数相邻元素的最大个数
        int res = 1,count = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        for(int num:arr){
            // 如果存在前面的数，就跳过，因为遍历到前一个数再判断最大个数肯定大于当前数；
            if(set.contains(num-1)) continue;
            //num++;
            // 因为count提前设置为1,所以应该先把num+1再循环判断；
            while(set.contains(++num)){
                count++;
                //num++;
            }
            // 每轮循环结束要更新最大值，并且将每轮循环临时最大值count置为 1；
            res = Math.max(res,count);
            count = 1;
        }
        return res;
    }
}
