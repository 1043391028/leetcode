package leetcode_208_Trie;

//  题目: 前缀树；
//  描述： 实现一个 Trie2 (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
//  示例:
//        Trie2 trie = new Trie2();
//
//        trie.insert("apple");
//        trie.search("apple");   // 返回 true
//        trie.search("app");     // 返回 false
//        trie.startsWith("app"); // 返回 true
//        trie.insert("app");
//        trie.search("app");     // 返回 true
// 说明:
//
//        你可以假设所有的输入都是由小写字母 a-z 构成的。
//        保证所有输入均为非空字符串。

//    下面方法太混乱，看Trie2;(思路都一样)

    class Trie {
        /** Initialize your data structure here. */
        class TrieNode{
            boolean isEnd;
            TrieNode[] next;
            private TrieNode(){
                isEnd = false;
                next = new TrieNode[26];
            }
        }
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(node.next[ch-'a']==null) {
                    node.next[ch-'a'] = new TrieNode();
                }
                node = node.next[ch-'a'];
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for(char ch:word.toCharArray()){
                node = node.next[ch-'a'];
                if(node == null) return false;
            }
            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(char ch:prefix.toCharArray()){
                node = node.next[ch-'a'];
                if(node == null) return false;
            }
            return true;
        }
    }
