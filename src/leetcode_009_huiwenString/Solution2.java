package leetcode_009_huiwenString;

//    思路二: 依次比较首尾数字;

public class Solution2 {
    public boolean isPalindrome(int x){
        // 边界判断
        if(x < 0) return false;
        // 保存最高位
        int div = 1;
        while(x / div > 0) div *=10;

        while(x > 0 ){
            int left = x/div;
            int right = x%10;
            if(left != right) return false;
            x = (x%div)/10; // 下一次 x 的值; x%100 除去高位; 再 /10 除去低位;
            div /=100; // div 需要除去100, 原数去掉两位;
        }
        return true;
    }
}
