package lc_1550_threeConsecutiveOdds;

//  题目：是否存在三个连续的奇数；
//  描述： 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
//           如果存在，请返回 true ；否则，返回 false 。

//   思路： 遍历判断；

public class Solution1 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]%2 == 1){
                count++;
                if(count >=3) return true;
            }else{
                if(count < 3){
                    count = 0;
                }
            }
        }
        return false;
    }
}
