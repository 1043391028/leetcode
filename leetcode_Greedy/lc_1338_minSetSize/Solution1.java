package lc_1338_minSetSize;

import java.util.Arrays;
import java.util.HashMap;

//  题目： 数组大小减半；
//        给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
//
//       返回 至少 能删除数组中的一半整数的整数集合的最小大小。
//
//示例 1：
//      输入：arr = [3,3,3,3,5,5,5,2,2,7]
//      输出：2
//解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
//       大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
//        选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
//
//  思路： HashMap + 数组（list）；

public class Solution1 {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int len =arr.length;
        int[] num = new int[map.values().size()];
        int index = 0;
        //  新建数组，并将数字出现的 个数 加进数组；
        for(int n : map.values()){
            num[index++] =n;
        }
        // 将数组排序；为了将次数多的先排除（贪心）这样能保证去掉最少的数；
        Arrays.sort(num);
        int res = 0,curCount = 0;
        for(int i=num.length-1;i>=0;i--){
            res++;
            curCount +=num[i];
            if(curCount >= len/2) return res;// 注意： len 为偶数；
        }
        return res;
    }
}
