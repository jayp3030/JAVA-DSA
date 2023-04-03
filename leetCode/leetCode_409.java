// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

// Example 1:
// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

// Example 2:
// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.

// Runtime: 4 ms, faster than 79.44% of Java online submissions for Longest Palindrome.
// Time Complexity : O(n)
class Solution {
    public int longestPalindrome(String s) {
        int length = 0;
        // Create a HashSet...
        HashSet<Character> hset = new HashSet<Character>();
        // Traverse every element through the loop...
        for (int idx = 0; idx < s.length(); idx++) {
            // Convert string to character array...
            char character = s.charAt(idx);
            // If hset contains character already, emove that character & adding 2 to length...
            // It means we get pair of character which is used in palindrome...
            if (hset.contains(character)) {
                length += 2;
                hset.remove(character);
            }
            // Otherwise, add the character to the hashset...
            else {
                hset.add(character);
            }
        }
        // If the size of the set is greater than zero, move length forward...
        if (hset.size() > 0) {
            length ++;
        }
        return length;      // Return the length of the longest palindrome...
    }
}