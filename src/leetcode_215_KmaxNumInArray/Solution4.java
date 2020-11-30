package leetcode_215_KmaxNumInArray;

//  思路4：双指针；
//         随机选取一个数组中随机数，然后用双指针（一头一尾）分别从前后遍历，交换顺序；、
//         最后，随机被选取的数两端分别是小于等于（左边），大于等于（右边）的数；

import java.util.Random;

public class Solution4 {
    private static Random random = new Random(System.currentTimeMillis());
    // 找元素函数
    public int findKthLargest(int[] nums, int k){
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    // 快排划分找位置函数；
    public int partition(int[] nums,int left,int right){
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }
        int pivot = nums[left];
        int l = left+1;
        int r = right;

        while(true){
            // 注意循环条件,nums[l] < pivot;
            while(l<=r && nums[l] < pivot){
                l++;
            }
            while(l<=r && nums[r] > pivot){
                r--;
            }
            if(l>r) break; // 这一步必须得有；很重要；
            swap(nums,l,r);
            l++;
            r--;
        }
        swap(nums,left,r);// 这里一定要把前面的标杆元素给换到排序的位置，并返回位置下标；
                          // 要换到左边，所以要用r,因为r最后位置位于左半边（小于等于pivot）
        return r;
    }

    // 元素交换函数；
    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
