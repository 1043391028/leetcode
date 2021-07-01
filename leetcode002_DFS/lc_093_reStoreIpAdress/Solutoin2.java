package lc_093_reStoreIpAdress;

import java.util.ArrayList;
import java.util.List;

public class Solutoin2 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        DFS(s,new ArrayList<String>(),0);
        return res;
    }

    public void DFS(String s,ArrayList<String> list,int index){
        if(index == s.length()){
            if(list.size() == 4)
            res.add(String.join(",",list));
            return;
        }
        if((4-list.size())*3>s.length()-index+1 || 4-list.size()>s.length()-index+1) return ;
        for(int i = index;i<index+3;i++){
            if(i>s.length()) break;
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
        for(int i = start;i<=end;i++){
            res = res*10 + s.charAt(i) - '0';
        }
        return res>=0 && res<=255;
    }
}
