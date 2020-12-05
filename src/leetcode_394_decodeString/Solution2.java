package leetcode_394_decodeString;

//  思路二: 递归法;


public class Solution2 {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }
   // 深度递归遍历,i 表示深度;
    public String[] dfs(String s,int i){
        // 新建字符串缓冲流res ;
        StringBuilder res = new StringBuilder();
        // 当前层某个字符串的倍数;
        int multy = 0;
        while(i < s.length()){
            if(s.charAt(i) > '0' && s.charAt(i) < '9') multy = multy*10 + s.charAt(i) - '0';
            // 如果为'[' 进入新的一层,新建temp数组,第一个数保存 i(遍历的深度),第二个保存遍历下一层得到的的字符串;
            else if(s.charAt(i) == '['){
                String[] temp = dfs(s,i+1);
                i = Integer.parseInt(temp[0]);  // i 位置需要更新到递归遍历到的位置;
                while(multy >0){
                    res.append(temp[1]);
                    multy--;
                }
            }
            // 如果为']' 结束当前层递归,但会结果(String数组);
            else if(s.charAt(i) == ']'){
                return new String[] {String.valueOf(i),res.toString()};
            }
            // 如果为字符直接加入res后面;
            else res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[] {res.toString()};
    }
}
