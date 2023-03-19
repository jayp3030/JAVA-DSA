// Design a data structure that supports adding new words and finding if a string matches any previously added string.
// Implement the WordDictionary class:
// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 
// Example:

// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output
// [null,null,null,null,false,true,true,true]

// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;

}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();   
    }
    
    public void addWord(String word) {
        TrieNode currentNode = root;
        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(currentNode.children[c-'a'] == null){
                currentNode.children[c-'a'] = new TrieNode();
            }
            currentNode = currentNode.children[c-'a'];
        }
        currentNode.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode currentNode = root;
        return helper(word , 0 , currentNode);
        
    }

    private boolean helper(String word , int i , TrieNode node){
        if(node == null) return false;

        if(i == word.length()) return node.isEnd;
        char c = word.charAt(i);

        if(c == '.'){
            for( int k = 0 ; k < 26 ; k++){
                if(helper(word , i+1 , node.children[k])) return true;
            }
        }
        else{
            if(helper(word , i+1 , node.children[c-'a'])) return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */