package leetcode_137_SingleNumII;

//  题目： 只出现依次的数字；
//  描述： 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
//
//  说明：
//        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//  思路一： HashMap;简单，但效率不高；

import java.util.HashMap;

public class Solution1 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        for(int num:nums){
            if(map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}
