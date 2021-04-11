package Face_test._001_MostPopular._010_SumOfBigDigital;

// 题目： 大数加法；
//  描述: 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
//         （ 字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）

//  思路一： 库函数：BigInteger, BigDecimal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution1 {
    public String solve (String s, String t) {
        // write code here
        BigInteger big1 = new BigInteger(s);
        BigInteger big2 = new BigInteger(t);
        return big1.add(big2).toString();
    }

    public String solve1 (String s, String t) {
        // write code here
        BigDecimal big1 = new BigDecimal(s);
        BigDecimal big2 = new BigDecimal(t);
        return big1.add(big2).toString();
    }
}
