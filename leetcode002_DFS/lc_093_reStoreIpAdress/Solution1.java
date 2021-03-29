package leetcode002_DFS.lc_093_reStoreIpAdress;

//  题目： 复原IP地址；
//  描述： 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。
//        你可以按任何顺序返回答案。
//        有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
//      但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
//
//示例 1：
//       输入：s = "25525511135"
//       输出：["255.255.11.135","255.255.111.35"]
//

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if(len < 4) return res;
        DFS(s,0,0,new ArrayList<>(),res);
        return res;
    }
    // DFS 递归+回溯；
    public void DFS(String s,int count,int start,List<String> temp,List<String> res){
        // 出口： start == len && ip 字段数 count为 4；
        if(start == s.length()){
            if(count == 4)
                res.add(String.join(",",temp));
            return ;
        }
        // 提前判断 i （当前遍历位）是否不符合条件；
        if(s.length() - start > (4-count)*3 || s.length() - start < 4-count) return;
        // 每层最多能遍历三位（ip地址段最多3位）；
        for(int i = 0;i <= 3;i++){
            // 当前位 i 是否越界；
            if(start + i >= s.length()) break;
            // 如果当前遍历位置符合条件（0 ~ 255）之间；
            if(IsValidNum(s,start,start + i)){
                temp.add(s.substring(start,start + i + 1));
                DFS(s,count+1,start+i+1,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
    // 判断是否有效当前层起始位置 start ~ 当前遍历位置 end 之间的字符串是否符合条件；
    public boolean IsValidNum(String s,int start,int end){
        if(start != end && s.charAt(start) == '0') return false;
        int res = 0;
        for(int i = start;i<=end;i++){
            res = res*10 + s.charAt(i) - '0';
        }
        return res>=0 && res<=255;
    }
}
