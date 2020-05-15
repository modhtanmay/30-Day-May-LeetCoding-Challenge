/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/


class TrieNode {
    char c;
    HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
    boolean checkLeaf;
    
    public TrieNode() {}
    
    public TrieNode(char c) {
        this.c = c;
    }
}
class Trie {

    /** Initialize your data structure here. */
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character, TrieNode> child = root.child;
        
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            
            TrieNode t;
            if(child.containsKey(c)){
                t = child.get(c);
            } else {
                t = new TrieNode(c);
                child.put(c,t);
            }
            
            child = t.child;
            
            if(i == word.length()-1)
                t.checkLeaf = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if(t!=null && t.checkLeaf)
            return true;
        else
            return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null)
            return false;
        else 
            return true;
    }
    
    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> child = root.child;
        TrieNode t = null;
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(child.containsKey(c)){
                t = child.get(c);
                child = t.child;
            } else {
                return null;
            }
        }
        return t;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
