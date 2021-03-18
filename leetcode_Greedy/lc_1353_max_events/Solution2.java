package lc_1353_max_events;

import java.util.Arrays;
import java.util.HashSet;

// 思路二： 将会议数组按照最先结束排序；(超时)
//           依次遍历数组，（最先结束的在前面）

public class Solution2 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(first, second)->first[1]==second[1]?first[0]-second[0]:first[1]-second[1]);
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int[] event:events){
            // i 表示当天天数，如果当天没用过，就加入HashSet;
            for(int i= event[0];i<=event[1];i++){
                if(set.add(i)) break;
            }
        }
        return set.size();
    }
}
