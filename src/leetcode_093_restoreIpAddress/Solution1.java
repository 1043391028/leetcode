package leetcode_093_restoreIpAddress;

//   题目: 复原IP地址;
//   描述:  给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
//          有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//      例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
//           但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
// 示例 1：
//         输入：s = "25525511135"
//         输出：["255.255.11.135","255.255.111.35"]
// 示例 2：
//         输入：s = "0000"
//         输出：["0.0.0.0"]
//

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution1 {
    public List<String> restoreIpAddresses(String s){
        int len = s.length();
        List<String> res = new ArrayList<>();
        if(len > 12 || len <4) return null;
        Deque<String> path = new ArrayDeque<>();
        dfs(s,0,len,4,path,res);
        return res;
    }

    public void dfs(String s, int start,int length,int addLength,Deque<String> path,List<String> res){
        if(start == length){
            if(addLength == 0) {
                res.add(String.join(".",path));
            }
            return ;
        }
        // 每一层逐渐从 1位字符 添加到 3位,一共四层(对应IP地址四段);
        for(int i = start;i<start+3;i++){
            if(start >= length) break;
            // 剩余ip地址段数*3 < 总长-当前遍历的位置;则一定不符合要求(剩余字符数太多,肯定有出界的);
            if(length-start > addLength*3) continue;
            if(validAdd(s,start,i)){
                String curString = s.substring(start,i+1);
                path.add(curString);
                dfs(s,i+1,length,addLength-1,path,res);
                path.removeLast();
            }
        }
    }
    // 判断当前截取的字符串是否为有效的地址段;
    public boolean validAdd(String s,int start,int end){
        // 长度>1 && 第一个字母为0 时是无效的;
        if(end-start+1 > 1 && s.charAt(start) == '0') return false;
        int res = 0;
        for(int i = start;i<=end;i++){
            res = res*10 + s.charAt(i)-'0';
        }
        return res >= 0 && res <= 255;
    }
}
