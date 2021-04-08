package Face_test._001_MostPopular._001_SumOfTwoNum;

import java.util.HashMap;

public class Solution2 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        int len = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int temp = numbers[i];
            if (map.containsKey(target - temp)) {
                res[1] = i + 1;
                res[0] = map.get(target - numbers[i]) + 1;
                return res;
            }
            map.put(numbers[i], i);
        }
        return res;
//         Collections.sort(map,new Compare(Entry<Integer,Integer> o1,Entry<Integer,Integer> o2){
//             @Override
//             public int compare(Entry<Integer,Integer> o1,Entry<Integer,Integer> o2){
//                 return o1.getKey() - o2.getKey();
//             }
//        });
    }
}
