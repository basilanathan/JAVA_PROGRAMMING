package fb.leetcode;

//A N S W E R

/**
 * 
 * @author basila
 * 
 * Design a data structure that supports the following two operations:
 *
 *	void addWord(word)
 *	bool search(word)
 *	search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *	
 *	For example:
 *	
 *	addWord("bad")
 *	addWord("dad")
 *	addWord("mad")
 *	search("pad") -> false
 *	search("bad") -> true
 *	search(".ad") -> true
 *	search("b..") -> true
 *	Note:
 *	You may assume that all words are consist of lowercase letters a-z.
 *
 *Time : Insert and search costs O(key_length)
 *Space : O(ALPHABET_SIZE * key_length * N) where N is number of keys in Trie
 *
 */

public class AddAndSearchWord {
	
	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	}
	
TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word, 0, root);
    }
    
    private boolean match(String word, int step, TrieNode node) {
        if (word.length() == step) return node.isWord;
        char c = word.charAt(step);
        if (c != '.') {
            return node.children[c-'a'] != null && match(word, step+1, node.children[c-'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && match(word, step+1, node.children[i])) return true;
            }
            return false;
        }
    }

}
