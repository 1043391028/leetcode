package lc_MainNumInArray;

  // 题目： 主要元素；
//   描述： 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

//    思路一： 1.利用‘自耗’ 法求得最多的元素 temp；
//            2. 遍历数组，判断 temp是否是过半的元素；

public class Solution1 {
    public int majorityElement(int[] nums) {
        int temp = nums[0],count = 1;
        // 第一遍遍历数组，求得数组种最多的元素；
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == temp){
                count++;
            }else{
                count--;
            }
            if(count < 1){
                temp = nums[i];
                count = 1;
            }
        }
        count = 0;
        // 第二次遍历，判断是否是过半的元素；
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == temp) count++;
        }
        return count > nums.length/2?temp:-1;
    }
}
