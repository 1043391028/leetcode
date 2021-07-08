package src.Face_test._002_NC._100_convertStringToNum;

//  题目： 将字符串转化为整数；
//  描述： 实现函数 atoi 。函数的功能为将字符串转化为整数
//  提示：仔细思考所有可能的输入情况。这个问题没有给出输入的限制，你需要自己考虑所有可能的情况。

//   思路一： 遍历判断；

public class Solution1 {
    public int atoi (String str) {
        // 排除 str = ""的情况；
        if(str.length() == 0) return 0;
        // 去除字符串前后空格
        String s = str.trim();
        // 将中间的空格去掉；
        s.replace("// ","");
        char [] arr = s.toCharArray();

        int index = 0, len = arr.length,res = 0,sign = 1;
        // 判断正负（只是第一个字符）
        if(arr[index] == '-'){
            sign = -1;
            index++;
        }
        if(arr[index] == '+') index++;
        // 定义正负边界值；
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        for(;index<len;index++){
            if(!Character.isDigit(arr[index])) break;
            int num = arr[index] -'0';
            if(res > max/10 || (sign > 0 && res == max/10 && num > 7) || (sign <0 && res ==max/10 && num >8))
                return sign == 1? max : min;
            //if(res > max/10 || (sign <0 && res ==max/10 && num >8) )
            //    return min;
            res = res*10 + num;
        }
        return sign == -1?-res:res;
    }
}
