package src.Face_test._001_MostPopular._026_sqrt;

// 题目： 求平方根；

//  思路一： 二分法；

public class Solution1 {
    public int sqrt (int x) {
        if(x == 0) return 0;
        // write code here
        int  l = 1, r = x;
        while(l<r){
            int mid = l+(r-l)/2;
            // 不能用 mid*mid <= x 判断，防止越界；
            if(mid <= x/mid && (mid+1) > x/(mid+1)) return mid;
            else if(mid > x/mid){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
