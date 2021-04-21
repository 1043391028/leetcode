package src.Face_test._001_MostPopular._024_durgeHuiwen;

// 思路二：
//        直接遍历；只需要遍历到mid(len/2)位置：len代表字符串的长度；

public class Solutions {
    public boolean judge (String str) {
        int len = str.length();
        for(int i = 0 ; i < len/2 ;i++)
        {
            if(str.charAt(i)!=str.charAt(len-1-i))
                return false;
        }
        return true;
    }
}
