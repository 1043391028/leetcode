package leetcode_017_letterOfPhoneNumber;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String str = "234";
        Solution1 solution1 = new Solution1();

        List< String > list = solution1.letterCombinations(str);

        System.out.println(list);
    }

}
