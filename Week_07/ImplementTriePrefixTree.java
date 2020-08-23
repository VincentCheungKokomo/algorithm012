//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 385 👎 0

package com.shuzijun.leetcode.editor.en;
public class ImplementTriePrefixTree{
    public static void main(String[] args) {
    Solution solution = new ImplementTriePrefixTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class TrieNode {
        private TrieNode[] links;   // R links to node children
        private final int R = 26; // 指向子节点的链接
        private boolean isEnd;  // 以指定节点是对应键的结尾还是只是键前缀

        public TrieNode() {
            links = new TrieNode[R];  // 构造函数 生成新的链接
        }

        // 检查是否包含该字符
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        // 从节点中获取字符
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        // 往节点中添加字符ch
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }


        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode(); // 根节点
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            // 遍历word中的每个字符
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i); // Java从字符串索引的方法
                // 如果不包含该字符 则创建一个新的节点
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());  // 往新的节点中添加当前字符
                }
                // 若已存在 则直接获取
                node = node.get(currentChar);
            }
            // 遍历完成后 设置到达尾端
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd(); // 若节点不为空 且 节点是叶子节点
        }

        /**search a prefix or whole key in trie and returns the node where search ends
         * 在字典树中搜索前缀或者整个键，并且当搜索结束时，返回该节点
         */
        private TrieNode searchPrefix(String word) {
            TrieNode node = root; // 从根节点开始搜索
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter); // 如果当前节点包含该字符 返回该链接指向的下一个节点
                } else {
                    return null;
                }
            }
            return node; // 遍历完成后 返回该节点
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node  = searchPrefix(prefix);
            return node != null;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}