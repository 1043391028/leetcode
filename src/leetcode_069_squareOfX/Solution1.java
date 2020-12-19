package leetcode_069_squareOfX;

//  题目: 求 X 的平方根;
//  描述: 实现 int sqrt(int x) 函数。
//
//        计算并返回 x 的平方根，其中 x 是非负整数。
//
//         由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//示例 1:
//         输入: 4
//         输出: 2

 //  思路一:  二分法;

public class Solution1 {
    public int mySqrt(int x) {
        //  需要单独判断 0 的情况;
        if(x == 0) return 0;
        //  当 x >= 4, (x/2)*(x/2) >= x;
        //   所以定义右边界为 x/2;
        long left = 1, right = x/2 ;
        while(left < right){
            // 此题二分一定要取右边界;
            //  因为下面二分压缩左右边界的情况是,压缩右边界,左边界不动,找到的时第一个数(假设为t) t^2 <= x < (t+1)^2;
            long mid = left + (right- left +1)/2;
            long square = mid*mid;
            if(square > x){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int)(left);
    }
}
