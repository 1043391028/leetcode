package Face_test._001_MostPopular._011_reverseDigital;

//  题目： 反转数字；
//  描述: 将给出的32位整数x翻转。
//         例1:x=123，返回321
//         例2:x=-123，返回-321
//        你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，
//   则其数值范围为[−2^{31}, 2^{31} − 1][−2^31,2^31−1]。翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。

public class Solution1 {
    public int reverse (int x) {
        // write code here
        int res = 0;
        while(x!=0) {
            int num = x%10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num >= 7)) {
                return -1;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num <= -8)) {
                return -1;
            }
            res = res*10 +x%10;
            x /=10;
        }
        return res;
    }

    //  public int reverse(int x) {
    //        int res = 0;
    //        while (x != 0) {
    //            int pop = x % 10;
    //            x /= 10;
    //            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop >= 7)) {
    //                return -1;
    //            }
    //            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop <= -8)) {
    //                return -1;
    //            }
    //            res = res * 10 + pop;
    //        }
    //        return res;
    //    }
}
