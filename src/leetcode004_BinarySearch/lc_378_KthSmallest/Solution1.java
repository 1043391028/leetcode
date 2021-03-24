package leetcode004_BinarySearch.lc_378_KthSmallest;

//  题目： 有序矩阵的第 k 小的元素；
//   描述： 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//          请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
//  思路一：
//         二分法；

public class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n-1][n-1];
        while(l<r){
            int mid = l + (r-l)/2;
            if(check(matrix,k,n,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean check(int[][] arr,int k,int n,int mid){
        int count = 0, i = n-1, j = 0;
        while(i>=0 && j<n){
            if(arr[i][j] <= mid){
                count += i+1;
                j++;
            }else{
                i--;
            }
        }
        return count >= k;
    }
}
