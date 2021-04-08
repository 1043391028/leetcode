package Face_test._001_MostPopular._002_LongestNotDumplacatedArr;

//  题目： 最长不重复子串；
//   描述： 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。

//  思路一： HashMap;（双指针）
//    思路二： 直接建立数组；（双指针）速度快很多，也更节省空间；；

import java.util.HashMap;

public class Solution1 {
    public int maxLength (int[] arr) {
        // write code here
        int len = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxlen = 1;
        for(int i = 0,j=0;j<len;j++){
            if(map.containsKey(arr[j])) maxlen = Math.max(maxlen,j-i);
            while(map.containsKey(arr[j])){
                map.remove(arr[i++]);
            }
            map.put(arr[j],j);
        }
        return maxlen;
    }
}
