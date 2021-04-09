package Face_test._001_MostPopular._005_SumOfThreeNum;

// 题目： 数组中元素和为0的三个数的集合；
//  描述： 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
//  注意：
//        三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
//        解集中不能包含重复的三元组。
//        例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)
//   思路一：
//          双指针；

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(num == null || num.length < 3) return res;
        Arrays.sort(num);
        int len = num.length;
        for(int i = 0;i<len-2;i++){
            // 注意点： 不能直接判断，要从第一个元素遍历后，判断后面的数和前面的一样则跳过；
            //           直接跳过会漏一些数据；
            if(i != 0 && num[i] == num[i-1]) continue;
            for(int j = i+1,k = len-1;j<k;){
                int sum = num[j] + num[k];
                if(num[i]+sum == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    res.add(list);
                    // 同样将重复的元素过滤掉；
                    while(j<k && num[j] == num[j+1]) j++;
                    while(k>j && num[k] == num[k-1]) k--;
                    // 最后继续左右分别往后移一个元素
                    j++;
                    k--;
                }else if(sum+num[i] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return res;
    }
}
