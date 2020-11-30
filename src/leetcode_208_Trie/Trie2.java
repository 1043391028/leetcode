package leetcode_208_Trie;

//   此题思路： 新建结点，每个结点包含26个该结点数组（即包含所有字母）
//      插入:   一次遍历所给单词字母，从根节点开始遍历，如果数组结点包含当前字母，
//              就接着遍历（并将结点变为新的字母位置结点），不包含，就新建一个结点，同样将结点更新为新的结点；
//   寻找单词： 遍历单词字母，从根节点搜寻，如果根节点数组结点该单词位置存在，将结点更新为新的结点，并往下遍历下一个单词；
//           不存在，返回 false;  最后遍历完单词，检查该单词是否是（某个单词）最后一个字母，是，返回true,否返回 false;
//  搜索前缀词：同搜索单词一样，只是最后返回结果不用检查是否是结尾字母；
class Trie2 {
    private boolean isString;
    private Trie2[] next;

    /** Initialize your data structure here. */
    public Trie2() {
        isString = false;
        next = new Trie2[26];
    }
    // Trie2 root = new Trie2();
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie2 node = this; // 这里注意，一定要这样写，不能新建 一个根节点初始化，然后赋值，会超出内存限制；
        for(char ch:word.toCharArray()){
            if(node.next[ch-'a'] == null) node.next[ch-'a'] = new Trie2();
            node = node.next[ch-'a'];
        }
        node.isString = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie2 node = this;
        for(char ch : word.toCharArray()){
            node = node.next[ch-'a'];
            if(node == null) return false;
        }
        return node.isString;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie2 node = this;
        for(char ch :prefix.toCharArray()){
            node = node.next[ch-'a'];
            if(node == null) return false;
        }
        return true;
    }
}
