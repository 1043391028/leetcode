package leetcode_189_RotatedArray;

//  思路三： 多次替换 或 递归（思想一样）

public class Solution3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k == 0 || n == 0) return ;
        Rerotated(nums,k,n,0);
    }
    // 递归函数；
    //  每次递归后，前 k 个数位置正确，后 n-k 个数的后 k 个不正确；
    //    然后进入下一层，把后 n-k 个数的后 k 个数排列正确；直到 k = 0;
    public void Rerotated(int[] nums,int k,int len,int start){
        k %=len;
        if(k != 0){
            for(int i = 0;i < k ; i++){
                int temp = nums[start + i];
                nums[start + i] = nums[nums.length-k+i];
                nums[nums.length-k+i] = temp;
            }
            Rerotated(nums, k, len-k, start+k);
        }
    }
}
