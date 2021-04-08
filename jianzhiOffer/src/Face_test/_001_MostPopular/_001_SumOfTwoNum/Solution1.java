package Face_test._001_MostPopular._001_SumOfTwoNum;

//  题目： 两数之和；
//   描述： 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
//          你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），
//           需要满足 index1 小于index2.。注意：下标是从1开始的
//        假设给出的数组中只存在唯一解
//  例如：
//        给出的数组为 {20, 70, 110, 150},目标值为90
//        输出 index1=1, index2=2

import java.util.HashMap;

//  思路一：  HashMap;（两遍遍历，思路简单，略显麻烦）；
//    思路二； HashMap；（一遍遍历）
//
public class Solution1 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        int len = numbers.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        //  将对应的数和下标保存；
        for(int i = 0;i<len;i++){
            map.put(numbers[i],i);
        }
//         Collections.sort(map,new Compare(Entry<Integer,Integer> o1,Entry<Integer,Integer> o2){
//             @Override
//             public int compare(Entry<Integer,Integer> o1,Entry<Integer,Integer> o2){
//                 return o1.getKey() - o2.getKey();
//             }
//         });
        //  遍历数组，（从前往后）查找对应的数
        for(int i = 0;i<len;i++){
            int temp = numbers[i];
            //  注意，map中找到满足条件的（两数的和），但是不能是自身
            if(map.containsKey(target - temp) && map.get(target-temp)!= i){
                //先把第一个数放到前面；
                res[0] = i+1;
                res[1] = map.get(target - temp)+1;
                return res;
            }
        }
        return res;
    }
}
