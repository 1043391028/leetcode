package src.Face_test._002_NC._NC054_SumOfThreeNum;

//  题目： 和为0的三个数集合；
//  描述：
//         给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
//  注意：
//        三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
//        解集中不能包含重复的三元组。

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for(int i = 0;i<len-2;i++){
            if(num[i] > 0) break;
            if(i>0 && num[i] == num[i-1]) continue; // 这一步去重必须有；
            int sum = -num[i];
            int j = i+1,k = len-1;
            while(j<k){
                if(num[k]+num[j] == sum){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    res.add(list);
                    // 去重；
                    while(j<k && num[j] == num[j+1]) j++;
                    while(j<k && num[k] == num[k-1]) k--;
                    //  指针左右移（压缩空间）必须有；
                    j++;
                    k--;
                }else if(num[k]+num[j]<sum){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}
