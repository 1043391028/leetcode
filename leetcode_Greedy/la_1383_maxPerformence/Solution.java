package la_1383_maxPerformence;

// 题目： 最大的团队表现值；
//        公司有编号为 1 到 n 的 n 个工程师，给你两个数组 speed 和 efficiency ，
//        其中 speed[i] 和 efficiency[i] 分别代表第 i 位工程师的速度和效率。请你返回由最多 k 个工程师组成的 ​
//     ​​​​​最大团队表现值 ，由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
//
//      团队表现值 的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」。
//
// 思路：

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        for(int i = 0;i< n;i++){
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }
        Arrays.sort(arr,(o1, o2)->o2[1]-o1[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 注意： 这里一定要用 long类型；
        long res = 0,sum = 0;
        for(int i = 0;i < n;i++){
            if(queue.size() > k-1){
                sum -= queue.poll();
            }
            res = Math.max(res,(sum + arr[i][0])*arr[i][1]);
            sum += arr[i][0];
            queue.add(arr[i][0]);
        }
        return (int)(res%((int)1e9+7));
    }
}
