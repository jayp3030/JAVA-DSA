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

      	// Search for a word in Trie

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i =0; i<word.length(); i++) {
          char ch = word.charAt(i);
          TrieNode node = currentNode.children.get(ch);
          if (node == null) {
            System.out.println("Word: "+word+ " does not exist in Trie");
            return false;
          }
          currentNode = node;
        }
        if (currentNode.endOfString == true) {
          System.out.println("Word: "+word+ " exists in Trie");
            return true;
        } else {
          System.out.println("Word: "+word+ " does not exist in Trie. But it is a prefix of another string");
        }
        return currentNode.endOfString;
      }
  
      // Delete a String from Trie
  
      private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;
  
        if (currentNode.children.size() > 1) {
          delete(currentNode, word, index+1);
          return false;
        }
        if (index == word.length() -1) {
          if (currentNode.children.size()>=1) {
            currentNode.endOfString = false;
            return false;
          } else {
            parentNode.children.remove(ch);
            return true;
          }
        }
        if (currentNode.endOfString == true) {
          delete(currentNode, word, index+1);
          return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if (canThisNodeBeDeleted == true) {
          parentNode.children.remove(ch);
          return true;
        } else {
          return false;
        }
      }
}
public class trieTree {
    public static void main(String[] args) {
        Trie t = new Trie();                                        // output : Trie is created successfully

        t.insert("API");                                            // output : Successfully inserted API in Trie
        t.insert("APIS");                                            // output : Successfully inserted APIS in Trie

        t.search("A");                                              // output : Word: A does not exist in Trie. But it is a prefix of another string
        
    }
}
