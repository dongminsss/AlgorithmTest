import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Trie trie = new Trie();
        for(String number : phone_book) {
            trie.insert(number);
        }
        
        for(String number : phone_book) {
            if(trie.startWith(number)) {
                answer = false;
                break;
            }   
        }
        
        
        return answer;
    }
    
    
}

class TrieNode {
    TrieNode[] children = new TrieNode[10];
    boolean isEndOfNumber;
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String str) {
        TrieNode node = root;
        for(char c : str.toCharArray()) {
            int idx = c - '0';
            if(node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEndOfNumber = true;
    }
    
    public boolean startWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            int idx = c - '0';
            if(node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return hasOtherNumber(node, true);
        
    }
    
    private boolean hasOtherNumber(TrieNode node, boolean isSelf) {
        if(isSelf) {
            isSelf =false;
        } else if (node.isEndOfNumber) {
            return true;
        }
        for(TrieNode child : node.children) {
            if(child != null && hasOtherNumber(child, isSelf)) return true;
        }
        return false;
    }
}