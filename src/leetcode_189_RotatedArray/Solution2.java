package leetcode_189_RotatedArray;

// 思路2： 三次旋转；
//         简单好理解，思路巧妙；

public class Solution2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k == 0 || n == 0) return ;
        k %=n;
        reverse(nums,0,n-1);// {1，2，3，4，5} k = 2为例：第一次旋转整个数；5，4，3，2，1
        reverse(nums,0,k-1);// 第二次旋转前 k 个数；{4,5,3,2,1}
        reverse(nums,k,n-1);     // 第三次旋转后 n-k 个元素；{4,5,1,2,3,}
    }

    public void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
