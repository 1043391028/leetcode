package leetcode_134_addGasStation;

//  题目：加油站；
//  描述： 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//         你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
//           你从其中的一个加油站出发，开始时油箱为空。
//
//         如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
// 说明: 
//        如果题目有解，该答案即为唯一答案。
//        输入数组均为非空数组，且长度相同。
//        输入数组中的元素均为非负数。
//
// 思路一：从头（i=0）的车站开始遍历；remain 表示当前站到下一站剩余的油量（可能为负值，表示到达不了），每次结果积累到下一个车站；
//           curreamin 表示所有站点中剩余油量的最小值；
//            如果到达某一个车站curremain的值< remain 说明当前站是能到达下一站的；
//              最后一个curreamin > reaamain 的站点i 就是能满足走一圈的站点（前提是spare > 0,也就是油量>里程数）；

public class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //  remain表示当前站点走到下一个站点剩余的油量；
        //  curremain 表示到当前站点剩余油量最小的；
        int remain = 0,curremain = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<gas.length;i++){
            remain += gas[i]-cost[i];
            // 当 remain < curremain 说明当前站点走不到下一个站点；
            // 当 remain >= curremain 说明当前站点可以走到下一个站点；
            if(remain < curremain){
                curremain = remain;
                index = i; // 更新的 index 为最小剩余油量的站点，该站点后面一定都能到达下一个站点（如果能够走完所有站点）
            }
        }
        return remain >= 0? (index+1)%gas.length:-1;
    }
}
