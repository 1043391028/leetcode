package leetcode_148_sortList;

//   题目: 排序链表;

//         给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
//   进阶：
//         你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

//   思路:  核心：遍历保存过程中 临时最大值 imax（表示到目前更新的最大值，可能是从中间的某一个值开始，因为中间可能会出现负数和0，
//                                             这样就得把之前的最大值丢掉，从后面继续算）
//          imin值保存最小值，因为很可能最大值碰到 负值后就变成了最小值，但是还不能丢弃，因为如果出现负值就可能变成最大值；


public class Solution1 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
//        初始最大值设为最小整数，这样只要遍历数组就会更新最大值；
        int max = Integer.MIN_VALUE;
//        初始临时最大最小值设置为 1 ；
        int imin = 1, imax = 1;
        for(int i = 0 ; i < nums.length ; i++){
            //这一步很重要，为了是最大和最小值互换，并且保存下来；
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
//            临时最大值最小值更新
            imax = Math.max(nums[i]*imax, nums[i]);
            imin = Math.min(nums[i]*imin,nums[i]);
//          过程中保存最大值
            max = Math.max(max,imax);
        }

        return max;
    }

}
