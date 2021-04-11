package Face_test._001_MostPopular._010_SumOfBigDigital;

//  思路二： StringBuilder();

public class Solution2 {
    public String solve (String s, String t) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1, j = t.length()-1;
        int a = 0, b = 0,sum =0, carry = 0;
        while(i>=0 || j>=0 || carry>0){
            a = i>=0?s.charAt(i--)-'0':0;
            b = j>=0?t.charAt(j--)-'0':0;
            sum = a+b+carry;
            carry = sum/10;
            sb.append(sum%10);
        }
        return sb.reverse().toString();
    }
}
