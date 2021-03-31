package FaceTest._001_getLongestPalinDrome;

//  思路二：
//         中心扩散法；

public class Solution2 {

        public int getLongestPalindrome(String A, int n) {
            // write code here
            int res = 1;
            char[] arr = A.toCharArray();
            //  遍历数组，分别从 i 和 i+1 向两边位置扩散；
            //   Maxlen 函数： 返回由 i 和 i+1 位置扩散的最长回文子串；
            for(int i =0;i<n;i++){
                int temp = Maxlen(arr,i,i)>Maxlen(arr,i,i+1)?Maxlen(arr,i,i):Maxlen(arr,i,i+1);
                res = Math.max(res,temp);
            }
            return res;
        }
        public int Maxlen(char[] arr,int i,int j) {
            while (i >= 0 && j < arr.length) {
                //  这里注意： 一定要有 if 判断， 不满足 ，立刻终止循环；
                //            i-- 和 j++ 向两边扩散；
                if (arr[i] == arr[j]) {
                    i--;
                    j++;
                } else {
                    break;
                }
            }
            // 结果 -2 是因为 退出循环时 i-- 和 j++;
            return j - i + 1 - 2;
        }
}
