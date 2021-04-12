package Face_test._001_MostPopular._013_convertStrToInt;

//  题目： 将字符串转换为整数；
//   描述： 实现函数 atoi 。函数的功能为将字符串转化为整数
//  提示：仔细思考所有可能的输入情况。这个问题没有给出输入的限制，你需要自己考虑所有可能的情况。

//  细节点：
//         1.字符串处理前后空格；
//         2. 正负号；
//         3. 越界处理；
//   注意： 本题是让得到截取从前往后正确的数字，遇到不符合条件的符号是停止，而不是返回-1；

public class Solution1 {
    public int atoi (String str) {
        // write code here
        if(str == null || str.length() == 0) return 0;
        //  这里一定注意，要将处理后的字符串放到新的字符串中；
        //   str.trim() 处理完空格本身并没有改变；
        String s = str.trim();
        int flag = 1, i = 0;
        // 首字符判断正负号；
        if(s.charAt(i) == '-'){
            flag = -1;
            i++;
        }
        if(s.charAt(i) == '+') i++;
        // 遍历字符串；
        int len = s.length();
        int res = 0;
        for(;i<len;i++){
            int val = s.charAt(i) - '0';
            // 当前字符串不为数字 停止；
            if(val>9 || val<0) break;
            if(res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && val>7)){
                if(flag > 0) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            res = res*10+val;
        }
        return res*flag;
    }
}
