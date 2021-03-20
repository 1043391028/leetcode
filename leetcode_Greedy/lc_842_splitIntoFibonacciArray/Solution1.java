package lc_842_splitIntoFibonacciArray;

// 题目： 将数组拆分成斐波那契数列；
//  描述: 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
//
//       形式上，斐波那契式序列是一个非负整数列表 F，且满足：
//              0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
//              F.length >= 3；
//       对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
//       另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
//
//       返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
//示例 1：
//        输入："123456579"
//        输出：[123,456,579]


//  思路： dfs + 回溯；

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backTrack(res,S.toCharArray(),0);
        return res;
    }
    public boolean backTrack(List<Integer> res,char[] s,int index){
        // 递归出口
        if(res.size()>=3 && index == s.length) return true;
        // 进入该层递归；
        for(int i=index;i<s.length;i++){
            // 两位数以上的数字第一个数字不能为0；
            if( i>index && s[index] == '0') break;
            // 截取字符串转换数字；（用long型速度快很多）
            long num = converNum(s,index,i);
            // 结果越界，返回false;
            if(num > Integer.MAX_VALUE) break;
            int size = res.size();
            // 当前数字 > 链表中后两个数字和 ，返回false（再往后肯定更大）;
            if(size >= 2 && num > res.get(size-1) + res.get(size-2)) break;
            //  满足结果， 加入队列，并进入下一层；
            if(size <= 1 || num == res.get(size-1)+res.get(size-2)){
                res.add((int)num);
                if(backTrack(res,s,i+1))
                    return true;
                //  为什么递归函数不定义为 void 而是 boolean类型？
                //  定义为 void 类型，每一次出上一层循环(哪怕找到正确的满足结果)都会再次经过 remove 结果最后返回完，队列中所有的元素都被remove;
                // 不return true 才把队列中结果出来；（满足就返回到上一层了，当前数字也不用出队列，这样最后一个数字遍历完
                //    如果满足，那么过程中所有的加入队列的数字都是满足的，就相当于把结果保留了；）
                res.remove(res.size()-1);
            }
        }
        return false;
    }

    public long converNum(char[] s,int start,int end){
        long res = 0;
        for(int i = start;i <= end;i++){
            res = res*10 + s[i]- '0';
        }
        return res;
    }
}
