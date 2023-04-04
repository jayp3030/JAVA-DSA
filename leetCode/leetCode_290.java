// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true

// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false

// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length)
            return false;

        HashMap<Character , String> map = new HashMap<>();

        for(int i = 0 ; i < pattern.length() ; i++){
            char c = pattern.charAt(i);

            // if map has word but there is not any key for that means there is different word 
            if(map.containsValue(words[i]) && !map.containsKey(c))
                return false;
            
            // if there is a key in map but the corressponding value of it and word in words in not same
            if(map.containsKey(c) && !map.get(c).equals(words[i]))
                return false;
            else
                map.put(c,words[i]);
        }
        return true;
    }
} 