package src.Face_test._001_MostPopular._037_ziDianOrderTree;

//  题目： 字典树；
//   描述： 字典树又称为前缀树或者Trie树，是处理字符串常用的数据结构。假设组成所有单词的字符仅是‘a’～‘z’，
//         请实现字典树的结构，并包含以下四个主要的功能。void insert(String word)：添加word，
//         可重复添加；void delete(String word)：删除word，如果word添加过多次，仅删除一次；
//         boolean search(String word)：查询word是否在字典树中出现过(完整的出现过，前缀式不算)；
//         int prefixNumber(String pre)：返回以字符串pre作为前缀的单词数量。现在给定一个m，表示有m次操作，
//         每次操作都为以上四种操作之一。每次操作会给定一个整数op和一个字符串word，op代表一个操作码，
//          如果op为1，则代表添加word，op为2则代表删除word，op为3则代表查询word是否在字典树中，
//           op为4代表返回以word为前缀的单词数量（数据保证不会删除不存在的word）。
//
//       对于每次操作，如果op为3时，如果word在字典树中，请输出“YES”，否则输出“NO”；
//                    如果op为4时，请输出返回以word为前缀的单词数量，其它情况不输出。

//  思路一：
//          HashMap 解法（本思路）；
//  思路二：
//         字典树；

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    // 构建树；
    class OrderTree{
        private HashMap<String,Integer> map;
        OrderTree(){
            map = new HashMap<>();
        }
        public void insert(String word){
            if(map.containsKey(word)){
                int count = map.get(word);
                map.put(word,count+1);
            }else{
                map.put(word,1);
            }
        }
        public void delete(String word){
            if(map.containsKey(word)){
                int count = map.get(word);
                if(count == 1) map.remove(word);
                else{
                    map.put(word,count-1);
                }
            }
        }
        public boolean search(String word){
            return map.containsKey(word);
        }
        public int prefixNumber(String word){
            int res = 0;
            for(String key:map.keySet()){
                if(key.indexOf(word) == 0){
                    res++;
                }
            }
            return res;
        }
    }
    public String[] trieU (String[][] operators) {
        // write code here
        OrderTree tree = new OrderTree();
        List<String> list = new ArrayList<>();
        for(String[] s : operators){
            switch(s[0]){
                case "1":
                    tree.insert(s[1]);
                    break;
                case "2":
                    tree.delete(s[1]);
                    break;
                case "3":
                    if(tree.search(s[1])) list.add("YES");
                    else list.add("NO");
                    break;
                case "4":
                    list.add(String.valueOf(tree.prefixNumber(s[1])));
                    break;
            }
        }
        String[] res = new String[list.size()];
        int index = 0;
        for(String s:list){
            res[index++] = s;
        }
        return res;
    }
}
