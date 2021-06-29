package src.Face_test._001_MostPopular._NC050_FindNumsApearonesInArray;

// 题目： 找出数组中只出现一次的两个数；

//  描述:  一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//  示例1
//         输入：
//               [1,4,1,6]
//      返回值：
//               [4,6]
//  说明：
//        返回的结果中较小的数排在前面

//   思路一： 双HashSet集合；
//            第一次遍历数组： set1添加所有的数 ，并判断是否重复，用set2 保存重复的数；
//            第二次遍历数组： 根据set2找其中不重复的两个数加入数组；

import java.util.HashSet;

public class Solution1 {
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for(int num:array){
            if(set1.contains(num)){
                set2.add(num);
            }
            set1.add(num);
        }
        int[] res = new int[2];
        int index = 0;
        for(int num:array){
            if(!set2.contains(num)){
                res[index++] = num;
            }
        }
        return res;
    }
}
