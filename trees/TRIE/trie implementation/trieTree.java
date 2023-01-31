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

    // insertion in trie

    public void insert(String word) {

        TrieNode current = root;

        for (int i=0; i<word.length(); i++) {
          char ch = word.charAt(i);
          TrieNode node = current.children.get(ch);
          if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
          }
          current = node;
        }
        current.endOfString = true;
        System.out.println("Successfully inserted " + word+ " in Trie");

      }
}
public class trieTree {
    public static void main(String[] args) {
        Trie t = new Trie();                                        // output : Trie is created successfully

        t.insert("API");                                            // output : Successfully inserted API in Trie
        t.insert("APIS");                                            // output : Successfully inserted APIS in Trie
        
    }
}
