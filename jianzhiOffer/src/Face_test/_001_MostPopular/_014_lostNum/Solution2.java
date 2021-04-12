package Face_test._001_MostPopular._014_lostNum;

//  思路二：
//         异 或运算；

public class Solution2 {
    public int solve (int[] a) {
        // write code here
        int sum = a.length;
        for(int i = 0;i<a.length;i++){
            sum ^= i^a[i];
        }
        return sum;
    }
}
