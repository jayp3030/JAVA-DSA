import java.util.*;

class TrieNode{

    public Map<Character , TrieNode> children;
    public boolean endOfString;

    public TrieNode(){
        children = new HashMap<>();
        endOfString = false;
    }
}
class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
        System.out.println("Trie is created successfully");
    }
}
public class trieTree {
    public static void main(String[] args) {
        Trie t = new Trie();                                        // output : Trie is created successfully
    }
}
