package Face_test._001_MostPopular._015_searchTartgetNumInCircleArray;

//  题目： 在转动过的有序数组中找目标数；
//  描述： 给出一个转动过的有序数组，你事先不知道该数组转动了多少
//         (例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
//        在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
//        假设数组中不存在重复项。

//  思路一：
//         二分；

public class Solution1 {
    public int search (int[] A, int target) {
        // write code here
        int len = A.length;
        int l = 0, r = len-1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(A[mid] == target) return mid;
            //  mid 两边的数必有一边是有序的；
            //  判断 target 是否在有序的那一半，不在就在另一半；
            if(A[mid] > A[l] && A[mid]>target && A[l] <= target){
                r = mid-1;
            }else if(A[mid]<A[l] &&!(A[r] > target && A[mid]< target)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}
