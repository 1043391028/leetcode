package leetcode_49_grouoAnagram;

//   题目： 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

//    思路一： hashMap<String,Deque<String>>;

import java.util.*;

public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        HashMap<String,Deque<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)) map.put(key,new LinkedList<>());
            map.get(key).addLast(s);
        }
        return new ArrayList(map.values());
    }
}
