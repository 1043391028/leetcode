package lc_1122_relativeArryySort;

//   题目描述： 给你两个数组，arr1 和 arr2，

//        arr2 中的元素各不相同
//         arr2 中的每个元素都出现在 arr1 中
//         对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
//           未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//
//示例：
//
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//        提示：
//             1 <= arr1.length, arr2.length <= 1000
//             0 <= arr1[i], arr2[i] <= 1000
//             arr2 中的元素 arr2[i] 各不相同
//             arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
//     核心思路：
//              1.将数组1中的元素，依次统计个数，放在新的数组中(该数组只保存arr1中存在的元素的个数)；
//              2. 遍历数组2，将 arr2中存在 arr1 中的数依次存入res数组；
//              3. 将arr1中没在arr2中出现的数依次从小到大加入res;

public class Solution1 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length,len2 = arr2.length;
        // 新建数组，保存arr1数组中个元素的个数
        int[] nums = new int[1001];
        // 结果数组；
        int[] res = new int[len1];
        // 结果数组序列 index,最大数maxValue;
        int index = 0,maxNum = 0;
        // 统计数组 1 中各个元素个数；
        for(int i:arr1){
            nums[i]++;
            maxNum = Math.max(maxNum,i);
        }
         // 依次遍历 数组2 中元素，取出数组1中存在的，放在结果数组中；
        for(int i:arr2){
            while(nums[i]>0){
                res[index++] = i;
                nums[i]--;
            }
        }
        // 最后把没有在数组 arr2中v出现的数按照大小存进结果数组 res 中
        for(int i =0; i<=maxNum; i++){
            while(nums[i] > 0){
                res[index++] = i;
                nums[i]--;
            }
        }
        return res;
    }
}
