package src.Face_test._001_MostPopular._026_sqrt;

//  所有的平方数，都是由 奇数相加得到；
//    1 = 1；
//      4 = 1+3；
//        9 = 1+3+5；

public class Solution2 {
    public int sqrt (int x) {
        if(x == 0) return 0;
        // write code here
        int count = 0; // 统计减去奇数的次数；
        int odd = 1;
        while(x >= 0){
            x -=odd;
            odd +=2;
            count++;
        }
        return count-1;
    }
}
