package lc_997_findJudge;

//   题目： 找到小镇法官；
//    描述：在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
//
//        如果小镇的法官真的存在，那么：
//                         小镇的法官不相信任何人。
//                          每个人（除了小镇法官外）都信任小镇的法官。
//                        只有一个人同时满足属性 1 和属性 2 。
//        给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
//
//     如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
//
//  思路： 小法官就是，被 N -1(除了自己) 个人信任的人；所以找到入度（信任度）为 N-1的人就是小法官；
//         遍历数组，构建入度图 weight[]；
//          将数组第二个元素代表的人 入度+1， 将第一个数代表的人入度 - 1；
//           最后遍历数组 weight[],入读为 N-1 的下标就是小法官；

public class Solution1 {
    public int findJudge(int N, int[][] trust) {
        int[] weight = new int[N+1];
        for(int[] num: trust){
            weight[num[1]]++;
            weight[num[0]]--;
        }
        for(int  i = 1;i <= N;i++){
            if(weight[i] == N-1){
                return i;
            }
        }
        return -1;
    }
}
