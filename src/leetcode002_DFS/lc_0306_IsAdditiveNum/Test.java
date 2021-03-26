package leetcode002_DFS.lc_0306_IsAdditiveNum;

public class Test {
    public static void main(String[] args) {
        String s1 = "199100199";
        String s2 = "112358";
        String s3 = "121474836472147483648";
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        //boolean res = solution1.isAdditiveNumber(s1);
        boolean res = solution2.isAdditiveNumber(s3);
        System.out.println(res);
    }
}
