package leetcode_04_findMidiaNumFromSortedArray;

//     题目：  给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//     思路1 ： 依次遍历两个数组，比较，遍历两个数组长度和的一半；

//            遍历过程判断并将较小数组下标的后移一位，最后按照数组和的奇偶个数来返回，最后一个或者倒数后两个的平均值；


public class solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int m = nums1.length;
            int n = nums2.length;
            int len = m+n;
            int astart = 0 , bstart = 0 ,right = -1, left = -1;
            for(int i = 0 ; i <= len/2;i++){
                left = right;
                if( astart < m && (bstart >= n ||nums1[astart] < nums2[bstart] ))
                    right = nums1[astart++]; // 数组1，当前指针后移的情况；
                else right = nums2[bstart++];  // 否则就数组2后移，因为必定存在，所以若不符合第一种情况，可以直接后移数组2；
            }
            if( (len & 1) == 0){
                return (left+right)/2.0;  // 为偶数，则返回最后两个数的均值；
            }else
                return right;  // 为奇数，直接返回最后一个就行；

    }


}
