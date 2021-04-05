package lc_0321_mergeMaxNum;

// 题目： 拼接最大数；
// 描述：  给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
//
//求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
//
//说明: 请尽可能地优化你算法的时间和空间复杂度。
//
//示例 1:
//       输入:
//             nums1 = [3, 4, 6, 5]
//             nums2 = [9, 1, 2, 5, 8, 3]
//             k = 5
//       输出:
//            [9, 8, 6, 5, 3]
//

public class Solution1 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[k];
        for(int i = Math.max(0,k-len2);i<=len1 && i<=k;i++){
            int[] arr1 = select(nums1,i);
            int[] arr2 = select(nums2,k-i);
            int[] temp = merge(arr1,arr2,k);
            res = durge(res,0,temp,0)?res:temp;
        }
        return res;
    }
    // 从数组 nums[] 中挑出 len 个数，是挑出的数最大；
    public int[] select(int[] nums,int len){
        int[] res = new int[len];
        for(int i = 0, j=0;i<nums.length;i++){
            // 保证已经挑出的数个数(j)剩余数的个数（nums.length-i）和 > len, 且当前数比已经挑出数的最后一位大；
            //     则将最后一个数弹出(弹出后下一步将nums[i] 加入到末尾，可使挑出的数最大)；
            while(nums.length-i+j>len && j>0 && nums[i]>res[j-1]) j--;
            if(j<len) res[j++] = nums[i];
        }
        return res;
    }
    // 合并两个数，这里不对；
    //    对于情况： nums1 ={6,7} , nums2 = {6,0,5} k = 5; 挑出的数是： 6，6，7，0，5；
    //               实际上应该是： 6，7，6，0，5；
    //              即，对于 前几个数相同的情况不能判断；
//    public int[] merge(int[] nums1, int[] nums2,int len){
//        int[] res = new int[len];
//        int index = 0, i= 0, j=0;
//        while(index<len && i<nums1.length && j<nums2.length){
//            res[index++] = nums1[i]>nums2[j]?nums1[i++]:nums2[j++];
//        }
//        while(index<len){
//            res[index++] = i == nums1.length?nums2[j++]:nums1[i++];
//        }
//        return res;
//    }
    public int[] merge(int[] nums1, int[] nums2,int len){
        int[] res = new int[len];
        int index = 0, i= 0, j=0;
        while(i<nums1.length || j<nums2.length)
            res[index++] = durge(nums1,i,nums2,j)?nums1[i++]:nums2[j++];
        return res;
    }

//    public int[] durge(int[] res,int[] temp){
//        int i = 0, j = 0, len1 = res.length,len2 = temp.length;
//        while(i<len1 && j<len2 && res[i] == temp[j]){
//            i++;
//            j++;
//        }
//        return j == len2 || (i<len1 && res[i] > temp[j])?res:temp;
//    }
    public boolean durge(int[] res,int i,int[] temp,int j){
        int len1 = res.length,len2 = temp.length;
        while(i<len1 && j<len2 && res[i] == temp[j]){
            i++;
            j++;
        }
        return j == len2 || (i<len1 && res[i] > temp[j]);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums1 = {3,4,6,5}, nums2 = {9,1,2,5,8,3};
        int len = 5;
        int[] res = new int[len];
        res = solution1.maxNumber(nums1,nums2,len);
        for(int num : res){
            System.out.println(num);
        }
    }
}
