package leetcode_05_longestHuiWenString;

public class Test {
    public static void main(String[] args) {
        String s = "abccccdfg" ;
        solution3 solution3 = new solution3();
        String str = solution3.longestPalindrome(s);
        System.out.println(str);
    }
}
