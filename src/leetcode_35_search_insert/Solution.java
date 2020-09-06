package leetcode_35_search_insert;

//二分法查找从小到大数组中第一个不小于该目标数的索引
// 如果有一连串数跟 target 相同，则返回索引最靠前的

// 特例：3 5 5 5 5 5 5 5 5 5
// 特例：3 6 7 8

// System.out.println("尝试过的值：" + mid);

// 1 2 3 5 5 5 5 5 5 6 ，target = 5
// 1 2 3 3 5 5 5 6 target = 4

public class Solution {

    public int searchInsert(int []nums,int target){
        int len = nums.length;
//        数组为空，返回-1；
        if (len ==0){
            return -1;
        }
//        如果目标数大于最后一个元素，则返回数组最后元素索引下标值+1；
        if(target>nums[len-1]){
            return len;
        }
        int left = 0;
        int right = len-1;

        while (left < right){
            int mid = (left + right)>>>1;//无符号右移获得中间数索引
            System.out.println("尝试过的值：" + mid);
            if (target > nums[mid]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return right;

    }

    public static void main(String[] args) {
        int numbers1 []={3,5 ,5 ,5 ,5 ,5 ,5 ,5 ,5 ,5};//target=5
        int numbers2 []={1,3,5 ,6 ,7 ,8,11};//target=6
        int numbers3 []={1,2,3,5 ,5 ,5 ,5,5 ,5,5,6};//target=5
        int numbers4 []={3,5 ,5 ,5 ,5 ,5 ,5 ,5 ,5 ,5};//target=6

        Solution solution = new Solution();
        //int rnum = solution.searchInsert(numbers1,5);
        int rnum = solution.searchInsert(numbers2,6);
        //int rnum = solution.searchInsert(numbers3,5);
        //int rnum = solution.searchInsert(numbers1,5);
        System.out.println("索引为： "+rnum);
    }
}

