package Face_test._001_MostPopular._014_lostNum;

//  题目： 寻找缺失的数；
//  描述 : 从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。

//  思路一：
//         二分；（条件中其实暗含排好序了）

public class Solution1 {
    public int solve (int[] a) {
        // write code here
        int l = 0,r = a.length-1;
        //  因为这个缺失的数一定存在，循环条件是 <= , 找的数就是出循环的下标；
        while(l<=r){
            int mid = l + (r-l)/2;
            if(a[mid] > mid) r = mid-1;
            else{
                l = mid+1;
            }
        }
        //return a[l] == l?l+1:l;
        return l;
    }
}
