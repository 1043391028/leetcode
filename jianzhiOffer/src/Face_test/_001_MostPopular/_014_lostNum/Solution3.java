package Face_test._001_MostPopular._014_lostNum;

// 思路三：
//        求和公式；

public class Solution3 {
    public int solve (int[] a) {
        // write code here
        int len = a.length;
        int Sum = (1+len)*len/2;
        int arrSum = 0;
        for(int i = 0;i<a.length;i++){
            arrSum += a[i];
        }
        return Sum - arrSum;
    }
}
