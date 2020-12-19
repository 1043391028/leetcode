package leetcode_071_simplifyPath;

//  题目: 简化路径;
//  描述: 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
//
//        在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
//         两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
//
//        请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
//         最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
//
//示例 1：
//         输入："/home/"
//         输出："/home"
//  解释：注意，最后一个目录名后面没有斜杠。

//  思路: 栈;
//         1. 用"/" 分割成字符串数组,新建一个栈 stack;(保存字符串'有效'的目录)
//         2. 遍历每个字符串s,遇到".."
//           2.1 如果 !stack.Empty() 入栈;(为空不入栈,不把".."当目录)
//         3. 不为".."
//            3.1 如果 s 不为空 && 不为"." 就入栈(相当于是一个有效的目录);
//

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public String simplifyPath(String path) {
        if(path == null) return null;
        String[] strs = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for(String s : strs){
            // 对于 "/.." 这种情况
            //  下面这种代码 返回的是 "/.." , 把.. 当成目录;
            //            if(!stack.isEmpty() && s.equals.("..")) stack.pop();
            //            else if(!s.isEmpty() && !s.equals(".")){
            //                stack.push(s);
            //            }
            // 下面代码返回的是 "/" , 把.. 不当成目录;
            if(s.equals("..")){
               if(!stack.isEmpty()) stack.pop();
            }
            else if(!s.isEmpty() && !s.equals(".")){
                stack.push(s);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append('/').append(stack.pollLast());
        }
        return res.length() == 0? "/" : res.toString();
        // return res.equals("")? "/" : res.toString(); 错误的;
     }

    public static void main(String[] args) {
        String s = "/..";
        Solution1 solution1 = new Solution1();
        String res = solution1.simplifyPath(s);
        System.out.println(res);
    }
}
