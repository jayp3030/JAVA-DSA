// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

// Example 1:
// Input: ransomNote = "a", magazine = "b"
// Output: false

// Example 2:
// Input: ransomNote = "aa", magazine = "ab"
// Output: false

// Example 3:
// Input: ransomNote = "aa", magazine = "aab"
// Output: true

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        int[] freq = new int[26];

        for(int i = 0 ; i < magazine.length() ; i++){
            char c = magazine.charAt(i);

            freq[c - 'a']++;
        }

        for( int i = 0 ; i < ransomNote.length() ; i++){
            char c = ransomNote.charAt(i);

            if(freq[c - 'a'] == 0) return false;
            freq[c-'a']--;
        }
        return true;
    }
}