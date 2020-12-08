package leetcode_621_taskArrange;

//  题目: 任务调度器;
//  描述: 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
//        任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
//          在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
//
//        然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，
//          因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
//
//        你 需要计算完成所有任务所需要的 最短时间 。
//
//  思路:
//       贪心;(将等待空闲时间尽量填满)
public class Solution1 {

    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        // 统计数组中字母最多的次数;(尽量将这些字母后面的冷却时间填满,是否填满决定最后结果,后面解释)
        int max =0;
        for(char ch:tasks){
            temp[ch-'A']++;
            max = Math.max(max,temp[ch-'A']);
        }
        int maxCount = 0; // maxCount 是为了统计多少个出现max次数的字母;(后面解释)
        for(int i=0;i < 26;i++){
            if(temp[i]== max) maxCount++;
        }
        int res = (max-1)*(n+1) + maxCount; //(max-1)*(n+1)是计算最多字母的冷却期,
                     // max-1 是因为最后一个A(次数最多的字母)后面的不需要等待,所以不算冷却期;
                  // maxCount 是因为同样次数的字母(假如B)不能放在A的冷却期(因为被B填满了)
        return Math.max(res,tasks.length); // 假如冷却期填满那么执行任务的时间就是任务的数量;
                                     // 没有填满,要按照冷却期计算(此时 res > tasks.length);
    }
}
