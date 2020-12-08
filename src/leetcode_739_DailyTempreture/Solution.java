package leetcode_739_DailyTempreture;

//   题目: 每日温度;
//   描述: 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
//         如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//   例如:  给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
//          你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

//   思路一:  暴力解答;

public class Solution {
    public int[] dailyTemperatures(int[] T){
        int length = T.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int current = T[i];
            if (current < 100) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
