package lc_093_reStoreIpAdress;

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
     //  保存结果；
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        DFS(s,new ArrayList<String>(),0);
        return res;
    }
    //  list保存每次递归的结果； index 代表每次递归入口；
    public void DFS(String s,ArrayList<String> list,int index){
        //  递归终止条件；
        if(index == s.length()){
            //  必须要判断list是否有4个元素；
            if(list.size() == 4)
                res.add(String.join(".",list));
            return;
        }
        //  每次递归最多三层；
        for(int i = index;i<index+3;i++){
            // 剪枝判断，不符合提前结束（提高效率）
            //   1.剩余字符比所剩字段*3还大；2. 所生字符个数还没所剩字段大。
            if((4-list.size())*3<s.length()-index || 4-list.size()>s.length()-index) return ;
            //  同样 i(当前遍历位置)不能超过s字符串长度；
            if(i>=s.length()) return;
            //  进入递归+回溯；
            if(isValidNum(s,index,i)){
                list.add(s.substring(index,i+1));
                DFS(s,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isValidNum(String s,int start,int end){
        if(start != end && s.charAt(start) == '0') return false;
        int res = 0;
        for(int i=start;i<=end;i++){
            res = res*10 + s.charAt(i) -'0';
        }
        return res>=0 && res<=255;
    }
}
