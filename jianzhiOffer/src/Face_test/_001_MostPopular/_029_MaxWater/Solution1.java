package src.Face_test._001_MostPopular._029_MaxWater;

//  题目： 容器盛水问题；
//  描述： 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。

//  思路一：
//         双端循环；

public class Solution1 {
    public long maxWater (int[] arr) {
        // write code here
        int len = arr.length;
        //  temp 保存每次从一端的某一个空段的水；res 保存总水量；
        long temp = 0, res = 0;
        // leftMax 某一段左边最高的；
        long leftMax = arr[0];
        // 从左往右循环遍历；
        for(int i = 0;i<len;i++){
            // 每一次遇到比左端最高的（leftMax）小的，就将差值加到temp中；
            //  遇到比 leftMax 大（包括等于）的就更新 res (加上temp 的值)
            if(arr[i]<leftMax){
                temp +=(leftMax-arr[i]);
            }else{
                res += temp;
                temp = 0;
                leftMax = arr[i];
            }
        }
        temp = 0;
        long rightMax = arr[len-1];
//        从右往左遍历；（注意，这次循环需要将等于的情况过滤掉，因为从左往右遍历的已经统计过）
        for(int j = len-1;j>=0;j--){
            if(arr[j] == rightMax) continue;
            if(arr[j]< rightMax){
                temp += (rightMax-arr[j]);
            }else{
                res += temp;
                rightMax = arr[j];
                temp = 0;
            }
        }
        return res;
    }
}
