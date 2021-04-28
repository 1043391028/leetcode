package src.Face_test._001_MostPopular._036_MaxMultyplicationOfSubArr;

//  题目: 子数组最大乘积；
//   描述： 给定一个double类型的数组arr，其中的元素可正可负可0，返回子数组累乘的最大乘积。
//    示例： [-2.5,4,0,3,0.5,8,-1]
///   输出： 12.0 （3*0.5*8）;

//  思路一：
///           遍历数组，将到当前位置的子数组最大值和最小值（负值）同时保留；

public class Solution1 {
    public double maxProduct(double[] arr) {
        if(arr.length == 0) return 0.0;
        // imin 保存到当前位置的子数组最小值（负数），imax 保存到当前位置的最大值；
        double imin = 1.0, imax = 1.0,max =arr[0];
        int len = arr.length;
        for(int i = 0;i<len;i++){
            // 遇到负数，交换最大值和最小值,保证 imax > 0, imin<0;
            if(arr[i] < 0){
                double temp = imax;
                imax = imin;
                imin = temp;
            }
            // 更新当前最大最小值（因为可能遇到 arr[i] == 0）,不一定每次 imax都大于0，imin<0;
            imax = Math.max(imax*arr[i],arr[i]);
            imin = Math.min(imin*arr[i],arr[i]);
            // 更新最大值（比较 imax, max）；
            max = Math.max(imax,max);
        }
        return max;
    }
}
