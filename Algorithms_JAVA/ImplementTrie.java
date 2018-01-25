package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Time: O(1)
 * Space: O(N)
 *
 */

class TrieNode {
	public boolean isWord;
	public TrieNode[] children = new TrieNode[26]; //giving each TrieNode a 26 element array of each possible child node it may have.
	public TrieNode() {};
}

public class ImplementTrie {
	private TrieNode root;
	public ImplementTrie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode ws = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(ws.children[c - 'a'] == null) {
				ws.children[c - 'a'] = new TrieNode();
			}
			ws = ws.children[c - 'a'];
		}
		ws.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNode ws = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(ws.children[c - 'a'] == null) return false;
			ws = ws.children[c - 'a'];
		}
		return ws.isWord;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode ws = root;
		for(int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if(ws.children[c - 'a'] == null) return false;
			ws = ws.children[c - 'a'];
		}
		return true;
	}

}


//WITH SEARCH HELPER FUNCTION

//class TrieNode {
//    public boolean isWord;
//    public TrieNode[] children = new TrieNode[26];
//    // Initialize your data structure here.
//    public TrieNode() {
//        
//    }
//}
//
//public class Trie {
//    private TrieNode root;
//
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    // Inserts a word into the trie.
//    public void insert(String word) {
//        TrieNode ws = root;
//        for(int i = 0; i < word.length(); i++){
//            char ch = word.charAt(i);
//            if(ws.children[ch - 'a'] == null){
//                ws.children[ch - 'a'] = new TrieNode();
//            }
//            ws = ws.children[ch - 'a'];
//        }
//        ws.isWord = true;
//    }
//
//    // Returns if the word is in the trie.
//    public boolean search(String word) {
//        TrieNode ws = searchHelper(word);
//        return ws != null && ws.isWord;
//    }
//
//    // Returns if there is any word in the trie
//    // that starts with the given prefix.
//    public boolean startsWith(String prefix) {
//         return searchHelper(prefix) != null;
//    }
//    
//    public TrieNode searchHelper(String key){
//        TrieNode ws = root;
//        for(int i = 0; i < key.length() && ws != null; i++){
//            char ch = key.charAt(i);
//            ws = ws.children[ch - 'a'];
//        }
//        return ws;
//    }
//}
