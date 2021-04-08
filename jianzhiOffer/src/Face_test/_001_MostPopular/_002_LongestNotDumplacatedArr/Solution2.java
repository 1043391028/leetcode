package Face_test._001_MostPopular._002_LongestNotDumplacatedArr;

//  思路二：
//         直接建立数组，保存某一个数的最新一次（最新遍历）的位置；

public class Solution2 {
    public int maxLength (int[] arr) {
        // write codejavascript:void(0); here
        int len = arr.length;
        int maxlen = 1;
        // 新建数组，保存数组中数最新一次出现的位置；
        int[] indexArr = new int[100005];
        for(int start = 0,end=0;end<len;end++){
            int index = arr[end];
            // 找到index(当前遍历的数之前最后一次出现的位置，没出现就为0)，
            //   和start对比，选出最大的作为滑动窗口的开始位置；
            start = Math.max(start,indexArr[index]);
            maxlen = Math.max(maxlen,end-start+1);
            // 将当前遍历的数的最新一次位置更新；
            indexArr[index] = end+1;
        }
        return maxlen;
    }
}
