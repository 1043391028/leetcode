package lc_1640_canFormArray;

// 题目: 1640. 能否连接形成数组
// 描述： 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，
//        其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。
//         但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
//       如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
//  示例 3：
//          输入：arr = [49,18,16], pieces = [[16,18,49]]
//          输出：false
//   解释：即便数字相符，也不能重新排列 pieces[0]
// 示例 4：
//         输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
//         输出：true
//   解释：依次连接 [91]、[4,64] 和 [78]
///   思路：
//          HashMap;

import java.util.HashMap;

public class canFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int len = arr.length;
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int[] p:pieces){
            map.put(p[0],p);
        }
        for(int i= 0;i<len;){
            if(!map.containsKey(arr[i])){
                return false;
            }
            int[] temp = map.get(arr[i]);
            for(int j = 0;j < temp.length;j++,i++){
                // 双循环，注意 pieces[][] 数组和arr[] 数组总数一样；
                if(arr[i] != temp[j]) return false;
            }
        }
        return true;
    }
}
