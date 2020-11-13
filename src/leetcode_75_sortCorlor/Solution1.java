package leetcode_75_sortCorlor;

//       题目：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//             此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//       注意:
//           不能使用代码库中的排序函数来解决这道题。

public class Solution1 {
    public void sortColors(int[] nums) {
        if(nums.length == 0 || nums == null) return ;
        int i = 0, l = 0 , r = nums.length;
        while(i < r){
            if(nums[i] == 0){
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
                i++;
            } else
            if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 2)
            {
                r--;
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
            }
        }
    }
}
