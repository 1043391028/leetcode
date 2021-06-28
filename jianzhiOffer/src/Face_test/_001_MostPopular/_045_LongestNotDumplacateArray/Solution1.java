package src.Face_test._001_MostPopular._045_LongestNotDumplacateArray;

// 题目： 最长无重复子数组；
//  描述： 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
//        子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组

import java.util.HashMap;

public class Solution1 {
    public int maxLength (int[] arr) {
        // write code here
        if(arr == null || arr.length == 0) return 0;
        int res = 1,curLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(arr[0],0);
        for(int left = 0,right = 1;right < arr.length;right++){
            if(map.containsKey(arr[right])){
                 // 在存到map中的数中查找是否有重复的数；
//                   如果有则判断重复的数是否在左边界的右边；如果是就更新左边界；
                left = Math.max(map.get(arr[right])+1,left);
            }
            // map中不存在当前数，就添加进 map;
            map.put(arr[right],right);
            // 更新最大值；
            curLen = right-left+1;
            res = Math.max(res,curLen);
        }
        return res;
    }
}
