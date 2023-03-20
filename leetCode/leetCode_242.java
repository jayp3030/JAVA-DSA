// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

class Solution {
    public boolean isAnagram(String s, String t) {
        if( s.length() > t.length()) return false;
        int[] freq = new int[26];

        for( int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            freq[c - 'a']++;
        }

        for( int i = 0 ; i < t.length() ; i++){
            char c = t.charAt(i);

            if(freq[c - 'a'] == 0) return false;
            freq[c - 'a']--;

        }
        return true;
    }
}