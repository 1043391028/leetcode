package leetcode_406_reconstructQueueByHight;

//   题目: 根据身高排序;
//   描述: 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
//         每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
//
//         请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
//         其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
//
// 示例 1：
//         输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//         输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//
//   思路:
//          1. 先给数组排序,排序依据:第一个数从大到小,第一个数相同,第二个数从小到大;
//          2. 把排好序的二维数组再次排序(用数组链表);排序依据: 依次遍历数组,把数组放到链表res中某位置(当前数组第二个数指向的位置);

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sokution1 {
    public int[][] reconstructQueue(int[][] people){
        // 第一次排序;
        Arrays.sort(people,(o1,o2)->o1[0] == o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        List<int[]> res = new ArrayList<>();
        // 第二次排序;
        for(int[] array:people){
            res.add(array[1],array);
        }
        // 链表转换数组;
        return res.toArray(new int[res.size()][2]);
    }
}
