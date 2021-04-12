package Face_test._001_MostPopular._007_LRU.LRUCache_02;

//  题目： 根据输入数组输出数据；

//     设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
//        set(key, value)：将记录(key, value)插入该结构
//        get(key)：返回key对应的value值
//  [要求]
//         set和get方法的时间复杂度为O(1)
//         某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
//         当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
//   若opt=1，接下来两个整数x, y，表示set(x, y)
//   若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
//   对于每个操作2，输出一个答案

import java.util.*;

public class Solution1 {
    public int[] LRU (int[][] operators, int k) {
        // write code here
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int len = operators.length;
        for (int i = 0; i < len; i++) {
            int flag = operators[i][0], key = operators[i][1];
            switch (flag) {
                case 1: {
                    if (map.size() >= k) {
                        Iterator it = map.entrySet().iterator();
                        it.next();
                        it.remove();
                    }
                    map.put(key, operators[i][2]);
                    break;
                }
                case 2: {
                    if (!map.containsKey(key)) {
                        res.add(-1);
                    } else {
                        int value = map.get(key);
                        map.remove(key);
                        map.put(key, value);
                        res.add(value);
                    }
                    break;
                }
            }

        }
        int[] ans = new int[res.size()];
        int index = 0;
        for (int num : res) {
            ans[index++] = num;
        }
        return ans;
    }
}
