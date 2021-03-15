package lc_1775_minOperations;

// 题目： 通过最少的操作次数使数组和相等；
// 描述:  给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
//
//           每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
//
//         请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。

//示例 1：
//        输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//        输出：3
//  解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//-         将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//-        将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//-        将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。


public class Solution1 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0,sum2 = 0;
        // 统计两数组和sum1和sum2;
        for(int num: nums1){
            sum1 += num;
        }
        for(int num:nums2){
            sum2 +=num;
        }
        //相等直接返回结果；
        if(sum2 == sum1) return 0;
        if(sum1 > sum2) return minOperations(nums2,nums1);
        // num 数组，存数字 1-6 的个数（也就是小数组可加、大数组可减的数字的个数）
        int[] num = new int[6];
        for(int i=0;i<nums1.length;i++){
            num[6-nums1[i]]++;
        }
        for(int j=0;j<nums2.length;j++){
            num[nums2[j]-1]++;
        }
        int res = 0 , div = sum2-sum1;
        for(int i=5;i>0 ;i--){
            while(num[i] != 0 && div>0){
                div -= i;
                res +=1;
                num[i]--;
                if(div<=0) return res;
            }
        }
        return -1;
    }
}
